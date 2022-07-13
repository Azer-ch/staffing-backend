package com.staffing.employee.service;

import com.staffing.dto.AddEmployeeRequest;
import com.staffing.employee.entity.Employee;
import com.staffing.employee.repository.EmployeeRepository;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.file.entity.File;
import com.staffing.file.service.FileService;
import com.staffing.information.address.entity.Address;
import com.staffing.information.address.repository.AddressRepository;
import com.staffing.information.complementaryInformation.entity.ComplementaryInformation;
import com.staffing.information.complementaryInformation.repository.ComplementaryInformationRepository;
import com.staffing.information.contractualAdvantages.entity.ContractualAdvantages;
import com.staffing.information.contractualAdvantages.repository.ContractualAdvantagesRepository;
import com.staffing.information.generalInformation.entity.GeneralInformation;
import com.staffing.information.generalInformation.repository.GeneralInformationRepository;
import com.staffing.role.entity.Role;
import com.staffing.enums.RoleEnum;
import com.staffing.role.repository.RoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Autowired
    private FileService fileService;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ComplementaryInformationRepository complementaryInformationRepository;
    @Autowired
    private GeneralInformationRepository generalInformationRepository;
    @Autowired
    private ContractualAdvantagesRepository contractualAdvantagesRepository;

    public Employee addEmployee(AddEmployeeRequest addEmployeeRequest, String roleName, Enterprise enterprise, MultipartFile[] files) throws NotFoundException, EmailAlreadyExistsException, IOException {
        if(employeeRepository.existsByEmail(addEmployeeRequest.getEmail())){
            throw new EmailAlreadyExistsException("email already exists");
        }
        if(!roleRepository.existsRoleByName(RoleEnum.valueOf(roleName))) {
            roleRepository.save(new Role(roleName));
        }
        if(!enterpriseRepository.existsByEnterpriseName(enterprise.getEnterpriseName())) {
            throw new NotFoundException("enterprise not found");
        }
        Address address = new Address(addEmployeeRequest.getCountry(), addEmployeeRequest.getCity(), addEmployeeRequest.getStreet(), addEmployeeRequest.getZipCode());
        ComplementaryInformation complementaryInformation = new ComplementaryInformation(addEmployeeRequest.getStatus(), addEmployeeRequest.getAvailableAt());
        GeneralInformation generalInformation = new GeneralInformation(addEmployeeRequest.getContract(), addEmployeeRequest.getStartDate(), addEmployeeRequest.getEndDate(), addEmployeeRequest.getCategory(), addEmployeeRequest.getAnnualNetSalary(), addEmployeeRequest.getChargeCoefficient(), addEmployeeRequest.getWorkTime(), addEmployeeRequest.getHourlyWage(), addEmployeeRequest.getCurrency(), addEmployeeRequest.getClassification(), addEmployeeRequest.getMonthlySalary(), addEmployeeRequest.getWorkDaysPerYear(), addEmployeeRequest.getWorkingHoursPerWeek());
        ContractualAdvantages contractualAdvantages = new ContractualAdvantages(addEmployeeRequest.getNavigoAmount(), addEmployeeRequest.getNavigoCharge(), addEmployeeRequest.getNavigoParticipationEmployee(), addEmployeeRequest.getMutuelleAmount(), addEmployeeRequest.getMutuelleCharge(), addEmployeeRequest.getMutuelleParticipationEmployee(), addEmployeeRequest.getRestaurantTicketsAmount(), addEmployeeRequest.getRestaurantTicketsCharge(), addEmployeeRequest.getRestaurantTicketParticipationEmployee());
        Employee employee = new Employee(addEmployeeRequest);
        addressRepository.save(address);
        complementaryInformationRepository.save(complementaryInformation);
        generalInformationRepository.save(generalInformation);
        contractualAdvantagesRepository.save(contractualAdvantages);
        employee.setAddress(address);
        employee.setComplementaryInformation(complementaryInformation);
        employee.setGeneralInformation(generalInformation);
        employee.setContractualAdvantages(contractualAdvantages);
        if(addEmployeeRequest.getHrSupervisor()!=null){
            if(employeeRepository.existsByEmail(addEmployeeRequest.getHrSupervisor())&&employeeRepository.findByEmail(addEmployeeRequest.getHrSupervisor()).getRoles().contains(roleRepository.findRoleByName(RoleEnum.ROLE_HR))) {
               employee.setHrSupervisor(employeeRepository.findByEmail(addEmployeeRequest.getHrSupervisor()));
            }
            else{
                throw new NotFoundException("hr supervisor not found");
            }
        }
        if(addEmployeeRequest.getManager()!=null){
            if(employeeRepository.existsByEmail(addEmployeeRequest.getManager())&&employeeRepository.findByEmail(addEmployeeRequest.getManager()).getRoles().contains(roleRepository.findRoleByName(RoleEnum.ROLE_MANAGER))) {
                employee.setManager(employeeRepository.findByEmail(addEmployeeRequest.getManager()));
            }
            else{
                throw new NotFoundException("manager not found");
            }
        }
        Role role = roleRepository.findRoleByName(RoleEnum.valueOf(roleName));
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employee.addRole(role);
        employee.setEnterprise(enterprise);
        employee.setActive(true);
        enterprise.addEmployee(employee);
        List<File> fileList = fileService.saveFiles(files);
        for(File file : fileList)
            employee.addCvs(file);
        return employeeRepository.save(employee);
    }
}
