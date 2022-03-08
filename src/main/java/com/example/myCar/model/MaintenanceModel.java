package com.example.myCar.model;

import lombok.Data;

import java.util.Calendar;

@Data
public class MaintenanceModel {
    private String maintenanceId;
    private String notes;
    private Calendar dateCreate;
    private Boolean isDelete;
    private Calendar dateOfDelete;
    private VehicleModel vehicleModel;
}
