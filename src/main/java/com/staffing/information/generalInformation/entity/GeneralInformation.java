package com.staffing.information.generalInformation.entity;

import com.staffing.enums.ContractEnum;

import javax.persistence.*;
import java.util.Currency;
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
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private String category;
    @Column
    private long annualNetSalary;
    @Column
    private float chargeCoefficient;
    @Column
    private String workTime;
    @Column
    private float hourlyWage;
    @Column
    private Currency currency;
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

    public GeneralInformation(ContractEnum contract, Date startDate, Date endDate, String category, long annualNetSalary, float chargeCoefficient, String workTime, float hourlyWage, Currency currency, String classification, double monthlySalary, int workDaysPerYear, float workingHoursPerWeek) {
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
