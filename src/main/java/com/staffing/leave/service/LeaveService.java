package com.staffing.leave.service;

import com.staffing.employee.entity.Employee;
import com.staffing.employee.repository.EmployeeRepository;
import com.staffing.enums.StatusEnum;
import com.staffing.leave.entity.Leave;
import com.staffing.leave.repository.LeaveRepository;
import com.staffing.mission.entity.Mission;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

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
                if (e.getStatus() != StatusEnum.DELETED)
                    if (leave.getStartDate().isBefore(e.getEndDate()) && leave.getStartDate().isAfter(e.getStartDate()) || leave.getEndDate().isAfter(e.getStartDate()) && leave.getEndDate().isBefore(e.getEndDate()) || leave.getStartDate().equals(e.getStartDate()) || leave.getEndDate().equals(e.getEndDate()) || (leave.getStartDate().isBefore(e.getStartDate()) && leave.getEndDate().isAfter(e.getEndDate())))
                        throw new Exception("A leave within the specified date already exists");
            }
        if (!employee.getMissions().isEmpty())
            for (Mission m : employee.getMissions()) {
                if (m.getStatus() != StatusEnum.DELETED)
                    if (leave.getStartDate().isBefore(m.getEndDate()) && leave.getStartDate().isAfter(m.getStartDate()) || leave.getEndDate().isAfter(m.getStartDate()) && leave.getEndDate().isBefore(m.getEndDate()) || leave.getStartDate().equals(m.getStartDate()) || leave.getEndDate().equals(m.getEndDate()) || (leave.getStartDate().isBefore(m.getStartDate()) && leave.getEndDate().isAfter(m.getEndDate())))
                        throw new Exception("A mission within the specified date already exists");
            }
        leave.setEmployee(employee);
        return leaveRepository.save(leave);
    }

    public void deleteLeave(Long id) throws Exception {
        if (!leaveRepository.existsById(id))
            throw new NotFoundException("Leave does not exist");
        Leave leave = leaveRepository.findById(id).get();
        leave.setStatus(StatusEnum.DELETED);
    }

    public void editLeave(Long id, Leave newLeave, String email) throws Exception {
        if (!leaveRepository.existsById(id))
            throw new NotFoundException("Leave does not exist");
        else {
            Leave leave = leaveRepository.findById(id).get();
            if (newLeave.getEndDate().isBefore(newLeave.getStartDate()))
                throw new Exception("End date should be greater than start date");
            if (!employeeRepository.existsByEmail(email))
                throw new NotFoundException("Employee does not exist");
            Employee employee = employeeRepository.findByEmail(email);
            if (!employee.getLeaves().isEmpty())
                for (Leave e : employee.getLeaves()) {
                    if (!Objects.equals(e.getId(), id) && e.getStatus() != StatusEnum.DELETED)
                        if (newLeave.getStartDate().isBefore(e.getEndDate()) && newLeave.getStartDate().isAfter(e.getStartDate()) || newLeave.getEndDate().isAfter(e.getStartDate()) && newLeave.getEndDate().isBefore(e.getEndDate()) || newLeave.getStartDate().equals(e.getStartDate()) || newLeave.getEndDate().equals(e.getEndDate()) || (newLeave.getStartDate().isBefore(e.getStartDate()) && newLeave.getEndDate().isAfter(e.getEndDate())))
                            throw new Exception("A Leave within the specified date already exists");
                }
            if (!employee.getMissions().isEmpty())
                for (Mission m : employee.getMissions()) {
                    if (m.getStatus() != StatusEnum.DELETED)
                        if (newLeave.getStartDate().isBefore(m.getEndDate()) && newLeave.getStartDate().isAfter(m.getStartDate()) || newLeave.getEndDate().isAfter(m.getStartDate()) && newLeave.getEndDate().isBefore(m.getEndDate()) || newLeave.getStartDate().equals(m.getStartDate()) || newLeave.getEndDate().equals(m.getEndDate()) || (newLeave.getStartDate().isBefore(m.getStartDate()) && newLeave.getEndDate().isAfter(m.getEndDate())))
                            throw new Exception("A mission within the specified date already exists");
                }
            leave.setStartDate(newLeave.getStartDate());
            leave.setEndDate(newLeave.getEndDate());
            leave.setEmployee(employee);
            leave.setType(newLeave.getType());

        }
    }

    public int countNumberOfLeaveDays(String email) throws Exception {
        if (!employeeRepository.existsByEmail(email))
            throw new NotFoundException("Employee does not exist");
        Employee employee = employeeRepository.findByEmail(email);
        int count = 0;
        for (Leave leave : employee.getLeaves()) {
            if (leave.getStatus() != StatusEnum.DELETED)
                count += DAYS.between(leave.getStartDate(), leave.getEndDate());
        }
        return count;
    }

    public List<Leave> getAllLeavesByEmployee(String email) throws Exception {
        if (!employeeRepository.existsByEmail(email))
            throw new Exception("Employee does not exist");
        List<Leave> leaves = new ArrayList<>();
        for (Leave leave : employeeRepository.findByEmail(email).getLeaves()) {
            if (leave.getStatus().equals(StatusEnum.ACCEPTED))
                leaves.add(leave);
        }
        return leaves;
    }
}
