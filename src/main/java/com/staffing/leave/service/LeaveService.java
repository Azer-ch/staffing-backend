package com.staffing.leave.service;

import com.staffing.leave.entity.Leave;
import com.staffing.leave.repository.LeaveRepository;
import com.staffing.employee.entity.Employee;
import com.staffing.employee.repository.EmployeeRepository;
import com.staffing.mission.entity.Mission;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public Leave addLeave(Leave leave, String email) throws Exception {
        if (leave.getEndDate().isBefore(leave.getStartDate()))
            throw new Exception("End date should be greater than start date");
        if (!employeeRepository.existsByEmail(email))
            throw new NotFoundException("Employee does not exist");
        Employee employee = employeeRepository.findByEmail(email);
        if (!employee.getLeaves().isEmpty())
            for (Leave e : employee.getLeaves()) {
                if (leave.getStartDate().isBefore(e.getEndDate()) && leave.getStartDate().isAfter(e.getStartDate()) || leave.getEndDate().isAfter(e.getStartDate()) && leave.getEndDate().isBefore(e.getEndDate())||leave.getStartDate().equals(e.getStartDate()) || leave.getEndDate().equals(e.getEndDate()))
                    throw new Exception("A leave within the specified date already exists");
            }
        if(!employee.getMissions().isEmpty())
            for (Mission m : employee.getMissions()) {
                if (leave.getStartDate().isBefore(m.getEndDate()) && leave.getStartDate().isAfter(m.getStartDate())|| leave.getEndDate().isAfter(m.getStartDate()) && leave.getEndDate().isBefore(m.getEndDate())||leave.getStartDate().equals(m.getStartDate()) || leave.getEndDate().equals(m.getEndDate()))
                    throw new Exception("A mission within the specified date already exists");
            }
        leave.setEmployee(employee);
        return leaveRepository.save(leave);
    }
    public List<Leave> getAllLeavesByEmployee(String email) throws Exception {
        if(!employeeRepository.existsByEmail(email))
            throw new Exception("Employee does not exist");
        return employeeRepository.findByEmail(email).getLeaves();
    }
}
