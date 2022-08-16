package com.staffing.employee.service;

import com.staffing.dto.AddEmployeeRequest;
import com.staffing.employee.entity.Employee;
import com.staffing.employee.repository.EmployeeRepository;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import com.staffing.enums.RoleEnum;
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
import com.staffing.information.param.entity.Param;
import com.staffing.information.param.repository.ParamRepository;
import com.staffing.role.entity.Role;
import com.staffing.role.repository.RoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
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
    @Autowired
    private ParamRepository paramRepository;

    public Employee addEmployee(AddEmployeeRequest addEmployeeRequest, String roleName, Enterprise enterprise, MultipartFile[] files) throws Exception {
        if (employeeRepository.existsByEmail(addEmployeeRequest.getEmail())) {
            throw new EmailAlreadyExistsException("email already exists");
        }
        if (!roleRepository.existsRoleByName(RoleEnum.valueOf(roleName))) {
            roleRepository.save(new Role(roleName));
        }
        if (!enterpriseRepository.existsByEnterpriseName(enterprise.getEnterpriseName())) {
            throw new NotFoundException("enterprise not found");
        }
        if(addEmployeeRequest.getEndDate().isBefore(addEmployeeRequest.getStartDate())){
            throw new Exception("end date must be greater than start date");
        }
        if(addEmployeeRequest.getAnnualNetSalary()<= 0){
            throw new Exception("annual net salary must be greater than 0");
        }
        if(addEmployeeRequest.getChargeCoefficient()<0){
            throw new Exception("charge coefficient must be greater than 0");
        }
        if(addEmployeeRequest.getHourlyWage()<= 0){
            throw new Exception("hourly wage must be greater than 0");
        }
        if(addEmployeeRequest.getMonthlySalary()<= 0){
            throw new Exception("monthly salary must be greater than 0");
        }
        if(addEmployeeRequest.getWorkDaysPerYear()<= 0){
            throw new Exception("work days per year must be greater than 0");
        }
        if(addEmployeeRequest.getTjm()<= 0){
            throw new Exception("tjm must be greater than 0");
        }
        if(addEmployeeRequest.getWorkingHoursPerWeek()<= 0){
            throw new Exception("working hours per week must be greater than 0");
        }
        Address address = new Address(addEmployeeRequest.getCountry(), addEmployeeRequest.getCity(), addEmployeeRequest.getStreet(), addEmployeeRequest.getZipCode());
        ComplementaryInformation complementaryInformation = new ComplementaryInformation(addEmployeeRequest.getStatus(), addEmployeeRequest.getAvailableAt(), addEmployeeRequest.getTjm(), addEmployeeRequest.getMobility());
        GeneralInformation generalInformation = new GeneralInformation(addEmployeeRequest.getContract(), addEmployeeRequest.getStartDate(), addEmployeeRequest.getEndDate(), addEmployeeRequest.getCategory(), addEmployeeRequest.getAnnualNetSalary(), addEmployeeRequest.getChargeCoefficient(), addEmployeeRequest.getWorkTime(), addEmployeeRequest.getHourlyWage(), addEmployeeRequest.getCurrency(), addEmployeeRequest.getClassification(), addEmployeeRequest.getMonthlySalary(), addEmployeeRequest.getWorkDaysPerYear(), addEmployeeRequest.getWorkingHoursPerWeek());
        ArrayList<Param> params = (ArrayList<Param>) addEmployeeRequest.getParamList();
        if (params != null) {
            for (Param param : params) {
                if (!paramRepository.existsByName(param.getName())) {
                    paramRepository.save(param);
                }
            }
        }
        ContractualAdvantages contractualAdvantages = new ContractualAdvantages(addEmployeeRequest.getParamList());
        Employee employee = new Employee(addEmployeeRequest);
        addressRepository.save(address);
        complementaryInformationRepository.save(complementaryInformation);
        generalInformationRepository.save(generalInformation);
        contractualAdvantagesRepository.save(contractualAdvantages);
        employee.setAddress(address);
        employee.setComplementaryInformation(complementaryInformation);
        employee.setGeneralInformation(generalInformation);
        employee.setContractualAdvantages(contractualAdvantages);
        if (addEmployeeRequest.getHrSupervisor()!=null&&addEmployeeRequest.getHrSupervisor().length() > 0) {

            if (employeeRepository.existsByEmail(addEmployeeRequest.getHrSupervisor()) && employeeRepository.findByEmail(addEmployeeRequest.getHrSupervisor()).getRoles().contains(roleRepository.findRoleByName(RoleEnum.ROLE_HR))) {
                employee.setHrSupervisor(employeeRepository.findByEmail(addEmployeeRequest.getHrSupervisor()));
            } else {
                throw new NotFoundException("hr supervisor not found");
            }
        }
        if (addEmployeeRequest.getManager()!=null&&addEmployeeRequest.getManager().length()>0) {
            if (employeeRepository.existsByEmail(addEmployeeRequest.getManager()) && employeeRepository.findByEmail(addEmployeeRequest.getManager()).getRoles().contains(roleRepository.findRoleByName(RoleEnum.ROLE_MANAGER))) {
                employee.setManager(employeeRepository.findByEmail(addEmployeeRequest.getManager()));
            } else {
                throw new NotFoundException("manager not found");
            }
        }
        Role role = roleRepository.findRoleByName(RoleEnum.valueOf(roleName));
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employee.addRole(role);
        employee.setEnterprise(enterprise);
        employee.setActive(true);
        enterprise.addEmployee(employee);
        List<File> fileList = fileService.saveFiles(files, employee);
        for (File file : fileList)
            employee.addCvs(file);
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) throws NotFoundException {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("employee not found"));
    }
}
