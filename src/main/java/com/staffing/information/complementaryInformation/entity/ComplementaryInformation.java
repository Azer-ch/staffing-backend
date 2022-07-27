package com.staffing.information.complementaryInformation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;

@Entity
@Table(name = "complementary_information")
public class ComplementaryInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String status;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate availableAt;
    @Column
    private int tjm;
    @Column
    private String mobility;
    public ComplementaryInformation(String status, LocalDate availableAt,int tjm, String mobility) {
        this.status = status;
        this.availableAt = availableAt;
        this.tjm = tjm;
        this.mobility = mobility;
    }

    public ComplementaryInformation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTjm() {
        return tjm;
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
        return "ComplementaryInformation{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", availableAt=" + availableAt +
                ", tjm=" + tjm +
                ", mobility='" + mobility + '\'' +
                '}';
    }
}
