package com.staffing.information.complementaryInformation.entity;

import javax.persistence.*;
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
    private Date availableAt;
    @Column
    private int tjm;
    @Column
    private String mobility;
    public ComplementaryInformation(String status, Date availableAt,int tjm, String mobility) {
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

    public Date getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(Date availableAt) {
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
}
