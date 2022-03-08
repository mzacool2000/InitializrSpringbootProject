package com.example.myCar.model;

import enums.CarType;
import lombok.Data;

@Data
public class CarModel extends VehicleModel{
    private CarType carType;
    private Integer numberOfDoors;
    private Integer capacity;
    private Double trunkCapacity;
}
