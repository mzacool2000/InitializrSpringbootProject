package com.example.myCar.model;

import lombok.Data;

@Data
public class VehicleModel {
    private String id;
    private String licensePlate;
    private String branch;
    private String model;
    private Integer modelYear;
    private Integer mileage;
    private Integer cylinderCapacity;
}
