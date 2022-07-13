package com.staffing.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.staffing.dto.AddEmployeeRequest;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enums.GenderEnum;
import com.staffing.file.entity.File;
import com.staffing.information.address.entity.Address;
import com.staffing.information.complementaryInformation.entity.ComplementaryInformation;
import com.staffing.information.contractualAdvantages.entity.ContractualAdvantages;
import com.staffing.information.generalInformation.entity.GeneralInformation;
import com.staffing.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;
    @Column
    private boolean isActive;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Column
    private Date dateOfBirth;
    @ManyToOne
    private Employee hrSupervisor;
    @ManyToOne
    private Employee manager;
    @Column
    private String type;
    @Column
    private String title;
    @Column
    private String phone;
    @OneToOne
    private Address address;
    @ManyToOne
    @JsonBackReference
    private Enterprise enterprise;
    @OneToOne
    private ComplementaryInformation complementaryInformation;
    @OneToOne
    private GeneralInformation generalInformation;
    @OneToOne
    private ContractualAdvantages contractualAdvantages;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<File> cvs = new ArrayList<>();

    public Employee() {
    }

    public Employee(String email, String password, String firstName, String lastName, GenderEnum gender, Date dateOfBirth, Employee hrSupervisor, Employee manager, String type, String title, String phone, Address address, Enterprise enterprise, ComplementaryInformation complementaryInformation, GeneralInformation generalInformation, ContractualAdvantages contractualAdvantages) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.hrSupervisor = hrSupervisor;
        this.manager = manager;
        this.type = type;
        this.title = title;
        this.phone = phone;
        this.address = address;
        this.enterprise = enterprise;
        this.complementaryInformation = complementaryInformation;
        this.generalInformation = generalInformation;
        this.contractualAdvantages = contractualAdvantages;
    }

    public Employee(AddEmployeeRequest addEmployeeRequest) {
        this.email = addEmployeeRequest.getEmail();
        this.password = addEmployeeRequest.getPassword();
        this.firstName = addEmployeeRequest.getFirstName();
        this.lastName = addEmployeeRequest.getLastName();
        this.gender = addEmployeeRequest.getGender();
        this.title = addEmployeeRequest.getTitle();
        this.type = addEmployeeRequest.getType();
        this.phone = addEmployeeRequest.getPhone();
        this.dateOfBirth = addEmployeeRequest.getDateOfBirth();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getHrSupervisor() {
        return hrSupervisor;
    }

    public void setHrSupervisor(Employee hrSupervisor) {
        this.hrSupervisor = hrSupervisor;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }

    public ContractualAdvantages getContractualAdvantages() {
        return contractualAdvantages;
    }

    public void setContractualAdvantages(ContractualAdvantages contractualAdvantages) {
        this.contractualAdvantages = contractualAdvantages;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ComplementaryInformation getComplementaryInformation() {
        return complementaryInformation;
    }

    public void setComplementaryInformation(ComplementaryInformation complementaryInformation) {
        this.complementaryInformation = complementaryInformation;
    }

    public List<File> getCvs() {
        return cvs;
    }

    public void setCvs(List<File> cvs) {
        this.cvs = cvs;
    }

    public void addCvs(File cv) {
        this.cvs.add(cv);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", hrSupervisor=" + hrSupervisor +
                ", manager=" + manager +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                ", enterprise=" + enterprise +
                ", generalInformation=" + generalInformation +
                ", contractualAdvantages=" + contractualAdvantages +
                '}';
    }
}
