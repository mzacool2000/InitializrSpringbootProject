/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myCar.entity;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author chiri
 */
@Entity
public class Maintenance {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String maintenanceId;
    private String notes;
    private Calendar dateCreate;
    private Boolean isDelete;
    private Calendar dateOfDelete;
    @ManyToOne
    private Vehicle vehicle;


    public Maintenance() {
    }

    public Maintenance(String maintenanceId, String notes, Calendar dateCreate, Boolean isDelete, Calendar dateOfDelete, Vehicle vehicle) {
        this.maintenanceId = maintenanceId;
        this.notes = notes;
        this.dateCreate = dateCreate;
        this.isDelete = isDelete;
        this.dateOfDelete = dateOfDelete;
        this.vehicle = vehicle;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Calendar getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Calendar dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Calendar getDateOfDelete() {
        return dateOfDelete;
    }

    public void setDateOfDelete(Calendar dateOfDelete) {
        this.dateOfDelete = dateOfDelete;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
