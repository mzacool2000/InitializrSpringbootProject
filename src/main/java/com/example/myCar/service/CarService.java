package com.example.myCar.service;

import com.example.myCar.entity.Car;
import com.example.myCar.model.CarModel;
import com.example.myCar.repository.CarRepository;
import enums.CarType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private VehiculoService vehiculoService;

    ModelMapper mapper = new ModelMapper();

    public CarService() {
    }

    @Transactional
    public CarModel create(CarModel carModel)throws ErrorService{
        Car car = mapper.map(carModel, Car.class);
        verifyEntity(car);
        vehiculoService.ValidateVehicle(car);
        return mapper.map(carRepository.save(car),CarModel.class);
    }

    public CarModel update(CarModel car) throws ErrorService {
        if (car.getId() == null){
            throw new ErrorService("id missing");
        }
            Optional<Car> response = carRepository.findById(car.getId());
            if (response.isPresent()) {
                return mapper.map(carRepository.save(mapper.map(car,Car.class)),CarModel.class);
            } else {
            throw new ErrorService("can,t be updated car id" + car.getId());
        }
    }

    public void delete(String id) throws ErrorService{
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()){
            carRepository.delete(car.get());
        }else {
            throw new ErrorService("can,t be deleted car id " + id);
        }


    }
    public CarModel find(String id) throws ErrorService{
        if (id == null){
            throw new ErrorService("id Missing");
        }
        Optional<Car> response = carRepository.findById(id);
        if (response.isPresent()) {
            return mapper.map(response.get(),CarModel.class);
        } else {
            throw new ErrorService("Car not fund");
        }
    }

    public List<CarModel> findAll(){
        List<Car> cars = new ArrayList<>();
        cars = carRepository.findAll();
        List<CarModel> carsModel = new ArrayList<>();
        for (Car car : cars) {
            carsModel.add(mapper.map(car,CarModel.class));
        }
        return carsModel;
    }


    public void verifyEntity(String carType, Integer numberOfDoors, Integer capacity, Double trunkCapacity) throws ErrorService {
        boolean areCarType = Arrays.stream(CarType.values()).anyMatch(carTypes -> carTypes.toString().equals(carType));
        boolean areNumberOfDoors = numberOfDoors != null ;
        boolean areCapacity = capacity != null ;
        boolean areTrunkCapacity = trunkCapacity != null ;
        if (!(areCapacity && areTrunkCapacity && areTrunkCapacity  && areNumberOfDoors && areCarType)) {
            throw new ErrorService("something is missing");
        }
    }
    public void verifyEntity(Car car) throws ErrorService{
        verifyEntity(car.getCarType().toString(),car.getNumberOfDoors(),car.getCapacity(),car.getTrunkCapacity());
    }
}
