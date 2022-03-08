package com.example.myCar;

import com.example.myCar.entity.Car;
import com.example.myCar.entity.Maintenance;
import com.example.myCar.entity.Truck;
import com.example.myCar.entity.Vehicle;
import enums.CarType;
import enums.TruckType;


import java.util.Calendar;
import java.util.UUID;

public class EntityTestFactory {
    static public Car createCarEntity(){
        Car car = new Car();
                car.setId(UUID.randomUUID().toString());
                car.setCarType(CarType.SPORTS_CAR);
                car.setCapacity(6);
                car.setNumberOfDoors(4);
                car.setTrunkCapacity(8.54);
                car.setCylinderCapacity(6);
                car.setBranch("Ford");
                car.setLicensePlate("AAA-111");
                car.setMileage(15000);
                car.setModel("ka");
                car.setModelYear(2019);
        return car;
    }
    static public Truck createTruckEntity(){
        Truck truck = new Truck();
        truck.setType(TruckType.CEMENT_TRUCK);
        truck.setBranch("Volvo");
        truck.setId(UUID.randomUUID().toString());
        truck.setCylinderCapacity(12);
        truck.setLicensePlate("AAA-222");
        truck.setNumberOfAxles(9);
        truck.setModel("XR4");
        truck.setMileage(20000);
        truck.setModelYear(2021);
        return truck;
    }
    static public Vehicle createVehicleEntity(){
        Vehicle vehicle = new Vehicle();
        vehicle.setBranch("Volvo");
        vehicle.setId(UUID.randomUUID().toString());
        vehicle.setCylinderCapacity(12);
        vehicle.setLicensePlate("AAA-222");
        vehicle.setModel("XR4");
        vehicle.setMileage(20000);
        vehicle.setModelYear(2021);
        return vehicle;
    }
    static public Maintenance createMaintenanceCarEntity(){
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(UUID.randomUUID().toString());
        maintenance.setDateCreate(Calendar.getInstance());
        maintenance.setNotes("sound crank crank");
        maintenance.setVehicle(createCarEntity());
        return maintenance;
    }
    static public Maintenance createMaintenanceTruckEntity(){
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(UUID.randomUUID().toString());
        maintenance.setDateCreate(Calendar.getInstance());
        maintenance.setNotes("sound crank crank");
        maintenance.setVehicle(createTruckEntity());
        return maintenance;
    }
}
