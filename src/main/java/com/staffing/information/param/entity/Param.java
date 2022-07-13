package com.staffing.information.param.entity;

import javax.persistence.*;

@Entity
@Table(name = "param")
public class Param {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private float navigoMontant;
    @Column
    private float mutuelleMontant;
    @Column
    private float restaurantMontant;

    public Param() {
    }

    public Param(float navigoMontant, float mutuelleMontant, float restaurantMontant) {
        this.navigoMontant = navigoMontant;
        this.mutuelleMontant = mutuelleMontant;
        this.restaurantMontant = restaurantMontant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getNavigoMontant() {
        return navigoMontant;
    }

    public void setNavigoMontant(float navigoMontant) {
        this.navigoMontant = navigoMontant;
    }

    public float getMutuelleMontant() {
        return mutuelleMontant;
    }

    public void setMutuelleMontant(float mutuelleMontant) {
        this.mutuelleMontant = mutuelleMontant;
    }

    public float getRestaurantMontant() {
        return restaurantMontant;
    }

    public void setRestaurantMontant(float restaurantMontant) {
        this.restaurantMontant = restaurantMontant;
    }

    @Override
    public String toString() {
        return "Param{" +
                "id=" + id +
                ", navigoMontant=" + navigoMontant +
                ", mutuelleMontant=" + mutuelleMontant +
                ", restaurantMontant=" + restaurantMontant +
                '}';
    }
}
