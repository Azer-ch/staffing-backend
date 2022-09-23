package com.staffing.mission.service;

import com.staffing.dto.AddMissionRequest;
import com.staffing.dto.MissionResponseDto;
import com.staffing.employee.entity.Employee;
import com.staffing.employee.repository.EmployeeRepository;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import com.staffing.enums.StatusEnum;
import com.staffing.leave.entity.Leave;
import com.staffing.mission.entity.Mission;
import com.staffing.mission.repository.MissionRepository;
import com.staffing.role.entity.Role;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.staffing.enums.RoleEnum.ROLE_ENGINEER;
import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Transactional
public class MissionService {
    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public Mission addMission(AddMissionRequest addMissionRequest) throws Exception {
        if (!enterpriseRepository.existsByEnterpriseName(addMissionRequest.getClient()))
            throw new Exception("Enterprise not found");
        if (addMissionRequest.getEndDate().isBefore(addMissionRequest.getStartDate()))
            throw new Exception("End date should be greater than start date");
        Mission mission = new Mission(addMissionRequest.getTitle(), enterpriseRepository.findByEnterpriseName(addMissionRequest.getClient()), addMissionRequest.getStartDate(), addMissionRequest.getEndDate(), new ArrayList<Employee>());
        for (String email : addMissionRequest.getEmployeeList()) {
            if (employeeRepository.existsByEmail(email)) {
                boolean isEngineer = false;
                for (Role role : employeeRepository.findByEmail(email).getRoles()) {
                    if (role.getName().equals(ROLE_ENGINEER.name())) {
                        isEngineer = true;
                    }
                }
                if (!isEngineer)
                    throw new NotFoundException("No engineer found with email: " + email);
            } else
                throw new NotFoundException("No employee found with email: " + email);
            Employee employee = employeeRepository.findByEmail(email);
            if (!employee.getLeaves().isEmpty())
                for (Leave e : employee.getLeaves()) {
                    if (e.getStatus() != StatusEnum.DELETED)
                        if (addMissionRequest.getStartDate().isBefore(e.getEndDate()) && addMissionRequest.getStartDate().isAfter(e.getStartDate()) || addMissionRequest.getEndDate().isAfter(e.getStartDate()) && addMissionRequest.getEndDate().isBefore(e.getEndDate()) || addMissionRequest.getStartDate().equals(e.getStartDate()) || addMissionRequest.getEndDate().equals(e.getEndDate()) || (addMissionRequest.getStartDate().isBefore(e.getStartDate()) && addMissionRequest.getEndDate().isAfter(e.getEndDate())))
                            throw new Exception("A leave within the specified date already exists for the employee: " + employee.getFirstName() + ' ' + employee.getLastName());
                }
            if (!employee.getMissions().isEmpty())
                for (Mission m : employee.getMissions()) {
                    if (m.getStatus() != StatusEnum.DELETED)
                        if (addMissionRequest.getStartDate().isBefore(m.getEndDate()) && addMissionRequest.getStartDate().isAfter(m.getStartDate()) || addMissionRequest.getEndDate().isAfter(m.getStartDate()) && addMissionRequest.getEndDate().isBefore(m.getEndDate()) || addMissionRequest.getStartDate().equals(m.getStartDate()) || addMissionRequest.getEndDate().equals(m.getEndDate()) || (addMissionRequest.getStartDate().isBefore(m.getStartDate()) && addMissionRequest.getEndDate().isAfter(m.getEndDate())))
                            throw new Exception("A mission within the specified date already exists for the employee: " + employee.getFirstName() + ' ' + employee.getLastName());
                }
            mission.addEmployee(employee);
            employee.addMission(mission);
            enterpriseRepository.findByEnterpriseName(addMissionRequest.getClient()).addMission(mission);
        }
        return missionRepository.save(mission);
    }

    public Mission editMission(Long id, AddMissionRequest newMission) throws Exception {
        if (!missionRepository.existsById(id))
            throw new NotFoundException("Mission not found");
        if (!enterpriseRepository.existsByEnterpriseName(newMission.getClient()))
            throw new NotFoundException("Enterprise not found");
        Mission mission = missionRepository.findById(id).get();
        mission.getEmployees().clear();
        for (String email : newMission.getEmployeeList()) {
            if (employeeRepository.existsByEmail(email)) {
                boolean isEngineer = false;
                for (Role role : employeeRepository.findByEmail(email).getRoles()) {
                    if (role.getName().equals(ROLE_ENGINEER.name())) {
                        isEngineer = true;
                    }
                }
                if (!isEngineer)
                    throw new NotFoundException("No engineer found with email: " + email);
            } else
                throw new NotFoundException("No employee found with email: " + email);
            Employee employee = employeeRepository.findByEmail(email);
            mission.addEmployee(employee);
            if (!employee.getLeaves().isEmpty())
                for (Leave e : employee.getLeaves()) {
                    if (e.getStatus() != StatusEnum.DELETED)
                        if (newMission.getStartDate().isBefore(e.getEndDate()) && newMission.getStartDate().isAfter(e.getStartDate()) || newMission.getEndDate().isAfter(e.getStartDate()) && newMission.getEndDate().isBefore(e.getEndDate()) || newMission.getStartDate().equals(e.getStartDate()) || newMission.getEndDate().equals(e.getEndDate()) || (newMission.getStartDate().isBefore(e.getStartDate()) && newMission.getEndDate().isAfter(e.getEndDate())))
                            throw new Exception("A leave within the specified date already exists for the employee: " + employee.getFirstName() + ' ' + employee.getLastName());
                }
            if (!employee.getMissions().isEmpty())
                for (Mission m : employee.getMissions()) {
                    if (!Objects.equals(m.getId(), id) && m.getStatus() != StatusEnum.DELETED)
                        if (newMission.getStartDate().isBefore(m.getEndDate()) && newMission.getStartDate().isAfter(m.getStartDate()) || newMission.getEndDate().isAfter(m.getStartDate()) && newMission.getEndDate().isBefore(m.getEndDate()) || newMission.getStartDate().equals(m.getStartDate()) || newMission.getEndDate().equals(m.getEndDate()) || (newMission.getStartDate().isBefore(m.getStartDate()) && newMission.getEndDate().isAfter(m.getEndDate())))
                            throw new Exception("A mission within the specified date already exists for the employee: " + employee.getFirstName() + ' ' + employee.getLastName());
                }
        }
        if (!newMission.getTitle().isEmpty())
            mission.setTitle(newMission.getTitle());
        if (!newMission.getStartDate().toString().isEmpty())
            mission.setStartDate(newMission.getStartDate());
        if (!newMission.getEndDate().toString().isEmpty())
            mission.setEndDate(newMission.getEndDate());
        mission.setClient(enterpriseRepository.findByEnterpriseName(newMission.getClient()));
        return mission;
    }

    public int countNumberOfMissionDays(String email) throws Exception {
        if (!employeeRepository.existsByEmail(email))
            throw new Exception("Employee does not exist");
        int count = 0;
        for (Mission m : employeeRepository.findByEmail(email).getMissions()) {
            count += DAYS.between(m.getStartDate(), m.getEndDate());
        }
        return count;
    }

    public Mission deleteMission(Long id, String enterprise) throws Exception {
        if (!missionRepository.existsById(id))
            throw new Exception("Mission not found");
        Mission mission = missionRepository.findById(id).get();
        if (!enterpriseRepository.existsByEmail(enterprise))
            throw new Exception("Enterprise not found");
        if (!Objects.equals(enterprise, mission.getClient().getEmail()))
            throw new Exception("This enterprise is not the owner of the mission");
        mission.setStatus(StatusEnum.DELETED);
        return mission;
    }

    public Mission validateMission(Long id, String enterprise) throws Exception {
        if (!missionRepository.existsById(id))
            throw new Exception("Mission not found");
        Mission mission = missionRepository.findById(id).get();
        if (!enterpriseRepository.existsByEmail(enterprise))
            throw new Exception("Enterprise not found");
        if (!Objects.equals(enterprise, mission.getClient().getEmail()))
            throw new Exception("This enterprise is not the owner of the mission");
        mission.setStatus(StatusEnum.ACCEPTED);
        return mission;
    }

    public List<Mission> getMissionsByEmployee(String email, StatusEnum status) throws Exception {
        if (!employeeRepository.existsByEmail(email))
            throw new Exception("Employee does not exist");
        List<Mission> missions = new ArrayList<>();
        for (Mission m : employeeRepository.findByEmail(email).getMissions()) {
            if (m.getStatus().equals(status))
                missions.add(m);
        }
        return missions;
    }

    public List<MissionResponseDto> getMissionsByEnterprise(String enterprise, StatusEnum status) throws Exception {
        if (!enterpriseRepository.existsByEmail(enterprise))
            throw new Exception("Enterprise not found");
        List<MissionResponseDto> missions = new ArrayList<>();
        for (Mission m : enterpriseRepository.findByEmail(enterprise).getMissions()) {
            if (m.getStatus().equals(status)) {
                MissionResponseDto missionResponseDto = new MissionResponseDto();
                missionResponseDto.setId(m.getId());
                missionResponseDto.setClient(enterpriseRepository.findByEmail(enterprise).getEnterpriseName());
                missionResponseDto.setTitle(m.getTitle());
                missionResponseDto.setStatus(status);
                missionResponseDto.setStartDate(m.getStartDate());
                missionResponseDto.setEndDate(m.getEndDate());
                for (Employee e : m.getEmployees()) {
                    missionResponseDto.addEmployee(e.getEmail());
                }
                missions.add(missionResponseDto);
            }
        }
        return missions;
    }

    public List<Employee> getEmployeesByMission(Long id) throws Exception {
        if (!missionRepository.existsById(id))
            throw new Exception("Mission not found");
        else {
            Mission mission = missionRepository.findById(id).get();
            return mission.getEmployees();
        }
    }

    public Enterprise getClientByMission(Long id) throws Exception {
        if (!missionRepository.existsById(id))
            throw new Exception("Mission not found");
        else {
            Mission mission = missionRepository.findById(id).get();
            return mission.getClient();
        }
    }
}