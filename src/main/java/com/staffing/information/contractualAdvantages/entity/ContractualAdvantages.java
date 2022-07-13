package com.staffing.information.contractualAdvantages.entity;

import javax.persistence.*;

@Entity
@Table(name = "contractual_advantages")
public class ContractualAdvantages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private float navigoAmount;
    @Column
    private float navigoCharge;
    @Column
    private float navigoParticipationEmployee;
    @Column
    private float mutuelleAmount;
    @Column
    private float mutuelleCharge;
    @Column
    private float mutuelleParticipationEmployee;
    @Column
    private float restaurantTicketsAmount;
    @Column
    private float restaurantTicketsCharge;

    @Column
    private float restaurantTicketParticipationEmployee;
    public ContractualAdvantages() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public float getNavigoParticipationEmployee() {
        return navigoParticipationEmployee;
    }

    public void setNavigoParticipationEmployee(float navigoParticipationEmployee) {
        this.navigoParticipationEmployee = navigoParticipationEmployee;
    }

    public float getMutuelleParticipationEmployee() {
        return mutuelleParticipationEmployee;
    }

    public void setMutuelleParticipationEmployee(float mutuelleParticipationEmployee) {
        this.mutuelleParticipationEmployee = mutuelleParticipationEmployee;
    }

    public float getRestaurantTicketParticipationEmployee() {
        return restaurantTicketParticipationEmployee;
    }

    public void setRestaurantTicketParticipationEmployee(float restaurantTicketParticipationEmployee) {
        this.restaurantTicketParticipationEmployee = restaurantTicketParticipationEmployee;
    }

    public ContractualAdvantages(float navigoAmount, float navigoCharge, float navigoParticipationEmployee, float mutuelleAmount, float mutuelleCharge, float mutuelleParticipationEmployee, float restaurantTicketsAmount, float restaurantTicketsCharge, float restaurantTicketParticipationEmployee) {
        this.navigoAmount = navigoAmount;
        this.navigoCharge = navigoCharge;
        this.navigoParticipationEmployee = navigoParticipationEmployee;
        this.mutuelleAmount = mutuelleAmount;
        this.mutuelleCharge = mutuelleCharge;
        this.mutuelleParticipationEmployee = mutuelleParticipationEmployee;
        this.restaurantTicketsAmount = restaurantTicketsAmount;
        this.restaurantTicketsCharge = restaurantTicketsCharge;
        this.restaurantTicketParticipationEmployee = restaurantTicketParticipationEmployee;
    }

    @Override
    public String toString() {
        return "ContractualAdvantages{" +
                "id=" + id +
                ", navigoAmount=" + navigoAmount +
                ", navigoCharge=" + navigoCharge +
                ", mutuelleAmount=" + mutuelleAmount +
                ", mutuelleCharge=" + mutuelleCharge +
                ", restaurantTicketsAmount=" + restaurantTicketsAmount +
                ", restaurantTicketsCharge=" + restaurantTicketsCharge +
                '}';
    }
}
