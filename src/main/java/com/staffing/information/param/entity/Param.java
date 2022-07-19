package com.staffing.information.param.entity;

import javax.persistence.*;

@Entity
@Table(name = "param")
public class Param {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private float amount;
    @Column
    private float charge;
    @Column
    private float participation;
    @Column
    private String type;
    public Param() {
    }

    public Param(String name, float amount, float charge, float participation, String type) {
        this.name = name;
        this.amount = amount;
        this.charge = charge;
        this.participation = participation;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public float getParticipation() {
        return participation;
    }

    public void setParticipation(float participation) {
        this.participation = participation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Param{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", charge=" + charge +
                ", participation=" + participation +
                ", type='" + type + '\'' +
                '}';
    }
}
