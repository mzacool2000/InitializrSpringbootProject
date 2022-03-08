package com.example.myCar.service;

import com.example.myCar.entity.Truck;
import com.example.myCar.model.TruckModel;
import com.example.myCar.repository.TruckRepository;
import enums.TruckType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TruckService {
    @Autowired
    private TruckRepository truckRepository;
    @Autowired
    private VehiculoService vehiculoService;

    ModelMapper mapper = new ModelMapper();

    public TruckModel create(TruckModel truckModel) throws ErrorService{
        try {
            Truck truck = mapper.map(truckModel, Truck.class);
            validateTruck(truck);
            vehiculoService.ValidateVehicle(truck);
            return mapper.map(truckRepository.save(truck),TruckModel.class);
        } catch (Exception e){
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public TruckModel update (TruckModel truckModel) throws ErrorService{
        if (truckModel.getId() == null) {
            throw new ErrorService("id missing");
        }
        Optional<Truck> response = truckRepository.findById(truckModel.getId());
        if (response.isPresent()){
            try{
        Truck truck = mapper.map(truckModel, Truck.class);
        validateTruck(truck);
        vehiculoService.ValidateVehicle(truck);
        return mapper.map(truckRepository.save(truck),TruckModel.class);
            } catch (Exception e){
                    System.err.println(e.getMessage());
                    throw e;
                }
            } else {
                throw new ErrorService("truck missing");
            }
    }
    public List<TruckModel> findAll(){
        List<TruckModel> trucksModel = new ArrayList<>();
        List<Truck> trucks = truckRepository.findAll();
        for (Truck truck : trucks) {
            trucksModel.add(mapper.map(truck,TruckModel.class));
        }
        return trucksModel;
    }


    public void validateTruck (Truck truck) throws ErrorService{
        validateTruck(truck.getType().toString(),truck.getNumberOfAxles());
    }

    public void validateTruck (String truckType, Integer numberOfAxes) throws ErrorService{
        Boolean areTruckType = Arrays.stream(TruckType.values()).anyMatch(truckTypes -> truckTypes.toString().equals(truckType));
        boolean areNumberAxes = numberOfAxes != null;
        if (!(areTruckType && areNumberAxes)){
            throw new ErrorService("something is missing");
        }
    }

    public TruckModel find(String id) throws ErrorService {
        if (id == null){
            throw new ErrorService("id Missing");
        }
        Optional<Truck> response = truckRepository.findById(id);
        if (response.isPresent()) {
            return mapper.map(response.get(), TruckModel.class);
        } else {
            throw new ErrorService("Truck not fund");
        }
    }

    public void delete(String id) throws ErrorService {
        Optional<Truck> car = truckRepository.findById(id);
        if (car.isPresent()){
            truckRepository.delete(car.get());
        }else {
            throw new ErrorService("can,t be deleted truck id " + id);
        }
    }
}
