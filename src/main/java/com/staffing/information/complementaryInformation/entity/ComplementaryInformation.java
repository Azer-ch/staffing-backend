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

    public ComplementaryInformation(String status, Date availableAt) {
        this.status = status;
        this.availableAt = availableAt;
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
}
