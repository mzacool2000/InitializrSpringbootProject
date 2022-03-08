package com.example.myCar.controller;

import com.example.myCar.entity.Car;
import com.example.myCar.entity.Maintenance;
import com.example.myCar.entity.Truck;
import com.example.myCar.entity.Vehicle;
import com.example.myCar.model.MaintenanceModel;
import com.example.myCar.repository.CarRepository;
import com.example.myCar.repository.MaintenanceRepository;
import com.example.myCar.repository.TruckRepository;
import com.example.myCar.service.ErrorService;
import com.example.myCar.service.MaintenanceService;
import enums.CarType;
import enums.TruckType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private TruckRepository truckRepository;
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @GetMapping("/all")
    public List<MaintenanceModel> allMaintenances() {
        return maintenanceService.findAll();
    }
    @GetMapping("/{id}")
    public MaintenanceModel Maintenance(@PathVariable("id") String id) throws ErrorService {
        try{
            return maintenanceService.find(id);
        }catch (Exception e){
            return null;
        }
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable ("id") String id) throws ErrorService {
        try{ maintenanceService.deleted(id);
            return "Maintenance id " + id + " was deleted";
        }catch (Exception e){
            return null;
        }
    }
    @PostMapping("/add")
    public MaintenanceModel createMaintenance(@RequestBody MaintenanceModel maintenanceModel)throws ErrorService{
        try{
            return maintenanceService.crate(maintenanceModel);
        }catch (Exception e){
            throw new ErrorService("wops");
        }
    }
    @PutMapping("/edit")
    public MaintenanceModel updateMaintenance(@RequestBody MaintenanceModel maintenanceModel) throws ErrorService {
        try {
            return maintenanceService.update(maintenanceModel);
        }catch (Exception e){
            throw new ErrorService("wops");
        }
    }
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
    static public Maintenance createMaintenanceCarEntity(){
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(UUID.randomUUID().toString());
        maintenance.setDateCreate(Calendar.getInstance());
        maintenance.setNotes("sound crank crank");
        maintenance.setVehicle(createVehicleEntity());
        return maintenance;
    }
    static public Maintenance createMaintenanceTruckEntity(){
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(UUID.randomUUID().toString());
        maintenance.setDateCreate(Calendar.getInstance());
        maintenance.setNotes("sound crank crank");
        maintenance.setVehicle(createVehicleEntity());
        return maintenance;
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
}
