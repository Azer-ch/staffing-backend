package com.staffing.mission.service;

import com.staffing.employee.entity.Employee;
import com.staffing.employee.repository.EmployeeRepository;
import com.staffing.leave.entity.Leave;
import com.staffing.mission.entity.Mission;
import com.staffing.mission.repository.MissionRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MissionService {
    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public Mission addMission(Mission mission, String email) throws Exception {
        if (mission.getEndDate().isBefore(mission.getStartDate()))
            throw new Exception("End date should be greater than start date");
        if (!employeeRepository.existsByEmail(email))
            throw new NotFoundException("Employee does not exist");
        Employee employee = employeeRepository.findByEmail(email);
        if (!employee.getLeaves().isEmpty())
            for (Leave e : employee.getLeaves()) {
                if (mission.getStartDate().isBefore(e.getEndDate()) && mission.getStartDate().isAfter(e.getStartDate())|| mission.getEndDate().isAfter(e.getStartDate()) &&mission.getEndDate().isBefore(e.getEndDate())||mission.getStartDate().equals(e.getStartDate()) || mission.getEndDate().equals(e.getEndDate()))
                    throw new Exception("A leave within the specified date already exists");
            }
        if (!employee.getMissions().isEmpty())
            for (Mission m : employee.getMissions()) {
                if (mission.getStartDate().isBefore(m.getEndDate()) && mission.getStartDate().isAfter(m.getStartDate()) || mission.getEndDate().isAfter(m.getStartDate())&&mission.getEndDate().isBefore(m.getEndDate())||mission.getStartDate().equals(m.getStartDate()) || mission.getEndDate().equals(m.getEndDate()))
                    throw new Exception("A mission within the specified date already exists");
            }
        mission.setEmployee(employee);
        return missionRepository.save(mission);
    }

    public List<Mission> getAllMissionsByEmployee(String email) throws Exception {
        if (!employeeRepository.existsByEmail(email))
            throw new Exception("Employee does not exist");
        return employeeRepository.findByEmail(email).getMissions();
    }
}