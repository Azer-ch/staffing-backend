package com.staffing.information.generalInformation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.staffing.enums.ContractEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "general_information")
public class GeneralInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ContractEnum contract;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @Column
    private String category;
    @Column
    private double annualNetSalary;
    @Column
    private float chargeCoefficient;
    @Column
    private String workTime;
    @Column
    private float hourlyWage;
    @Column
    private String currency;
    @Column
    private String classification;
    @Column
    private double monthlySalary;
    @Column
    private int workDaysPerYear;
    @Column
    private float workingHoursPerWeek;

    public GeneralInformation() {
    }

    public GeneralInformation(ContractEnum contract, LocalDate startDate, LocalDate endDate, String category, double annualNetSalary, float chargeCoefficient, String workTime, float hourlyWage, String currency, String classification, double monthlySalary, int workDaysPerYear, float workingHoursPerWeek) {
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "GeneralInformation{" +
                "id=" + id +
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
                '}';
    }
}
