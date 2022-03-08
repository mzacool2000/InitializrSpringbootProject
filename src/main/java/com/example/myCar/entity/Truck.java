/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myCar.entity;

import enums.TruckType;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

/**
 *
 * @author chiri
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Truck extends Vehicle {
    private TruckType type;
    private Integer numberOfAxles;


    public Truck() {

    }

    public TruckType getType() {
        return type;
    }

    public void setType(TruckType type) {
        this.type = type;
    }

    public Integer getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(Integer numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }
}
