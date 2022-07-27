package com.staffing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.staffing.enums.ContractEnum;
import com.staffing.enums.GenderEnum;
import com.staffing.information.param.entity.Param;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class AddEmployeeRequest {
    private String email;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private GenderEnum gender;
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String hrSupervisor;
    private String manager;
    private String type;
    private String title;
    private String phone;
    private String country;
    private String street;
    private String city;
    private long zipCode;
    private ContractEnum contract;
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String category;
    private double annualNetSalary;
    private float chargeCoefficient;
    private String workTime;
    private float hourlyWage;
    private String currency;
    private String classification;
    private double monthlySalary;
    private int workDaysPerYear;
    private float workingHoursPerWeek;
    private List<Param> paramList;
    private String status;
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate availableAt;
    private int tjm;
    private String mobility;

    public AddEmployeeRequest(String email, String password, String role, String firstName, String lastName, GenderEnum gender, LocalDate dateOfBirth, String hrSupervisor, String manager, String type, String title, String phone, String country, String street, String city, long zipCode, ContractEnum contract, LocalDate startDate, LocalDate endDate, String category, double annualNetSalary, float chargeCoefficient, String workTime, float hourlyWage, String currency, String classification, double monthlySalary, int workDaysPerYear, float workingHoursPerWeek, ArrayList<Param> paramList, String status, LocalDate availableAt,int tjm, String mobility) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.hrSupervisor = hrSupervisor;
        this.manager = manager;
        this.type = type;
        this.title = title;
        this.phone = phone;
        this.country = country;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.contract = contract;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.annualNetSalary = annualNetSalary;
        this.chargeCoefficient = chargeCoefficient;
        this.workTime = workTime;
        this.hourlyWage = hourlyWage;
        this.currency = currency;
        this.classification = classification;
        this.monthlySalary = monthlySalary;
        this.workDaysPerYear = workDaysPerYear;
        this.workingHoursPerWeek = workingHoursPerWeek;
        this.paramList = paramList;
        this.status = status;
        this.availableAt = availableAt;
        this.tjm = tjm;
        this.mobility = mobility;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(LocalDate availableAt) {
        this.availableAt = availableAt;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHrSupervisor() {
        return hrSupervisor;
    }

    public void setHrSupervisor(String hrSupervisor) {
        this.hrSupervisor = hrSupervisor;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public ContractEnum getContract() {
        return contract;
    }

    public void setContract(ContractEnum contract) {
        this.contract = contract;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAnnualNetSalary() {
        return annualNetSalary;
    }

    public void setAnnualNetSalary(double annualNetSalary) {
        this.annualNetSalary = annualNetSalary;
    }

    public float getChargeCoefficient() {
        return chargeCoefficient;
    }

    public void setChargeCoefficient(float chargeCoefficient) {
        this.chargeCoefficient = chargeCoefficient;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public float getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(float hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getWorkDaysPerYear() {
        return workDaysPerYear;
    }

    public void setWorkDaysPerYear(int workDaysPerYear) {
        this.workDaysPerYear = workDaysPerYear;
    }

    public float getWorkingHoursPerWeek() {
        return workingHoursPerWeek;
    }

    public void setWorkingHoursPerWeek(float workingHoursPerWeek) {
        this.workingHoursPerWeek = workingHoursPerWeek;
    }


    public int getTjm() {
        return tjm;
    }

    public List<Param> getParamList() {
        return paramList;
    }

    public void setParamList(List<Param> paramList) {
        this.paramList = paramList;
    }

    public void setTjm(int tjm) {
        this.tjm = tjm;
    }

    public String getMobility() {
        return mobility;
    }

    public void setMobility(String mobility) {
        this.mobility = mobility;
    }

    @Override
    public String toString() {
        return "AddEmployeeRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", hrSupervisor='" + hrSupervisor + '\'' +
                ", manager='" + manager + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", contract=" + contract +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", category='" + category + '\'' +
                ", annualNetSalary=" + annualNetSalary +
                ", chargeCoefficient=" + chargeCoefficient +
                ", workTime='" + workTime + '\'' +
                ", hourlyWage=" + hourlyWage +
                ", currency=" + currency +
                ", classification='" + classification + '\'' +
                ", monthlySalary=" + monthlySalary +
                ", workDaysPerYear=" + workDaysPerYear +
                ", workingHoursPerWeek=" + workingHoursPerWeek +
                ", paramList=" + paramList +
                ", status='" + status + '\'' +
                ", availableAt=" + availableAt +
                ", tjm=" + tjm +
                ", mobility='" + mobility + '\'' +
                '}';
    }
}
