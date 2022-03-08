/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myCar.entity;

import enums.CarType;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author chiri
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Car extends Vehicle {
    private CarType carType;
    private Integer numberOfDoors;
    private Integer capacity;
    private Double trunkCapacity;

    public Car() {

    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(Double trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }
}
