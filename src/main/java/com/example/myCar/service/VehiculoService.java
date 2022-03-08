package com.example.myCar.service;

import com.example.myCar.entity.Car;
import com.example.myCar.entity.Truck;
import com.example.myCar.entity.Vehicle;
import com.example.myCar.model.VehicleModel;
import com.example.myCar.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehiculoService {
    @Autowired
    public VehicleRepository vehicleRepository;

    ModelMapper mapper = new ModelMapper();

    public VehicleModel find(String id)throws ErrorService{
        if (id == null){
            throw new ErrorService("you meed a id vehicle");
        }
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()){
            return mapper.map(vehicle.get(),VehicleModel.class);
        } else {
            throw new ErrorService("dont find a vehicle id");
        }
    }
    public void validateVehicle( String licensePlate, String branch,String model,
                                Integer modelYear,Integer mileage,Integer cylinderCapacity) throws ErrorService {
        boolean areBranch = branch != null;
        boolean areLicencePlate = licensePlate != null;
        boolean areModel = model != null;
        boolean areModelYear = modelYear != null;
        boolean areMileage = mileage != null;
        boolean areCylinderCapacity = cylinderCapacity != null;

        if(!(areBranch && areCylinderCapacity && areMileage && areLicencePlate && areModel && areModelYear)){
            throw new ErrorService("softing missing");
        }
    }
    public void ValidateVehicle(Car vehicle) throws ErrorService {
        validateVehicle(vehicle.getLicensePlate(),vehicle.getBranch(),vehicle.getModel(),vehicle.getModelYear(),
                vehicle.getMileage(),vehicle.getCylinderCapacity());
        }
    public void ValidateVehicle(Truck vehicle) throws ErrorService {
        validateVehicle(vehicle.getLicensePlate(),vehicle.getBranch(),vehicle.getModel(),vehicle.getModelYear(),
                vehicle.getMileage(),vehicle.getCylinderCapacity());
    }
    public void ValidateVehicle(Vehicle vehicle) throws ErrorService {
        validateVehicle(vehicle.getLicensePlate(),vehicle.getBranch(),vehicle.getModel(),vehicle.getModelYear(),
                vehicle.getMileage(),vehicle.getCylinderCapacity());
    }
    }
