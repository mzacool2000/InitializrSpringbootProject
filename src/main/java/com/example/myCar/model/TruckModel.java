package com.example.myCar.model;

import enums.TruckType;
import lombok.Data;

@Data
public class TruckModel extends VehicleModel{
    private TruckType type;
    private Integer numberOfAxles;
}
