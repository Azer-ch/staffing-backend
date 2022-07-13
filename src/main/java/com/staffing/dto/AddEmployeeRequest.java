package com.staffing.dto;

import com.staffing.enums.ContractEnum;
import com.staffing.enums.GenderEnum;

import java.util.Currency;
import java.util.Date;

public class AddEmployeeRequest {
    private String email;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private GenderEnum gender;
    private Date dateOfBirth;
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
    private Date startDate;
    private Date endDate;
    private String category;
    private long annualNetSalary;
    private float chargeCoefficient;
    private String workTime;
    private float hourlyWage;
    private Currency currency;
    private String classification;
    private double monthlySalary;
    private int workDaysPerYear;
    private float workingHoursPerWeek;
    private float navigoAmount;
    private float navigoCharge;
    private float navigoParticipationEmployee;
    private float mutuelleAmount;
    private float mutuelleCharge;
    private float mutuelleParticipationEmployee;
    private float restaurantTicketsAmount;
    private float restaurantTicketsCharge;
    private float restaurantTicketParticipationEmployee;
    private String status;
    private Date availableAt;

    public AddEmployeeRequest(String email, String password, String role, String firstName, String lastName, GenderEnum gender, Date dateOfBirth, String hrSupervisor, String manager, String type, String title, String phone, String country, String street, String city, long zipCode, ContractEnum contract, Date startDate, Date endDate, String category, long annualNetSalary, float chargeCoefficient, String workTime, float hourlyWage, Currency currency, String classification, double monthlySalary, int workDaysPerYear, float workingHoursPerWeek, float navigoAmount, float navigoCharge, float navigoParticipationEmployee, float mutuelleAmount, float mutuelleCharge, float mutuelleParticipationEmployee, float restaurantTicketsAmount, float restaurantTicketsCharge, float restaurantTicketParticipationEmployee, String status, Date availableAt) {
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
        this.navigoAmount = navigoAmount;
        this.navigoCharge = navigoCharge;
        this.navigoParticipationEmployee = navigoParticipationEmployee;
        this.mutuelleAmount = mutuelleAmount;
        this.mutuelleCharge = mutuelleCharge;
        this.mutuelleParticipationEmployee = mutuelleParticipationEmployee;
        this.restaurantTicketsAmount = restaurantTicketsAmount;
        this.restaurantTicketsCharge = restaurantTicketsCharge;
        this.restaurantTicketParticipationEmployee = restaurantTicketParticipationEmployee;
        this.status = status;
        this.availableAt = availableAt;
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

    public float getMutuelleParticipationEmployee() {
        return mutuelleParticipationEmployee;
    }

    public void setMutuelleParticipationEmployee(float mutuelleParticipationEmployee) {
        this.mutuelleParticipationEmployee = mutuelleParticipationEmployee;
    }

    public float getRestaurantTicketsAmount() {
        return restaurantTicketsAmount;
    }

    public void setRestaurantTicketsAmount(float restaurantTicketsAmount) {
        this.restaurantTicketsAmount = restaurantTicketsAmount;
    }

    public float getRestaurantTicketsCharge() {
        return restaurantTicketsCharge;
    }

    public void setRestaurantTicketsCharge(float restaurantTicketsCharge) {
        this.restaurantTicketsCharge = restaurantTicketsCharge;
    }

    public float getRestaurantTicketParticipationEmployee() {
        return restaurantTicketParticipationEmployee;
    }

    public void setRestaurantTicketParticipationEmployee(float restaurantTicketParticipationEmployee) {
        this.restaurantTicketParticipationEmployee = restaurantTicketParticipationEmployee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(Date availableAt) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getAnnualNetSalary() {
        return annualNetSalary;
    }

    public void setAnnualNetSalary(long annualNetSalary) {
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
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

    public float getNavigoAmount() {
        return navigoAmount;
    }

    public void setNavigoAmount(float navigoAmount) {
        this.navigoAmount = navigoAmount;
    }

    public float getNavigoCharge() {
        return navigoCharge;
    }

    public void setNavigoCharge(float navigoCharge) {
        this.navigoCharge = navigoCharge;
    }

    public float getNavigoParticipationEmployee() {
        return navigoParticipationEmployee;
    }

    public void setNavigoParticipationEmployee(float navigoParticipationEmployee) {
        this.navigoParticipationEmployee = navigoParticipationEmployee;
    }

    public float getMutuelleAmount() {
        return mutuelleAmount;
    }

    public void setMutuelleAmount(float mutuelleAmount) {
        this.mutuelleAmount = mutuelleAmount;
    }

    public float getMutuelleCharge() {
        return mutuelleCharge;
    }

    public void setMutuelleCharge(float mutuelleCharge) {
        this.mutuelleCharge = mutuelleCharge;
    }
}
