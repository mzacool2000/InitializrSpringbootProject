package com.example.myCar.controller;


import com.example.myCar.model.CarModel;
import com.example.myCar.service.CarService;
import com.example.myCar.service.ErrorService;
import com.example.myCar.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<CarModel> allCars() {
        return carService.findAll();
    }
    @GetMapping("/{id}")
    public CarModel car(@PathVariable ("id") String id) throws ErrorService {
        try{
            return carService.find(id);
        }catch (Exception e){
            return null;
        }
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable ("id") String id) throws ErrorService {
        try{
            carService.delete(id);
            return "car id " + id + " was deleted";
        }catch (Exception e){
            return null;
        }
    }
    @PostMapping("/add")
    public CarModel createCar(@RequestBody CarModel carModel)throws ErrorService{
        try{
            return carService.create(carModel);
        }catch (Exception e){
        throw new ErrorService("wops");
        }
    }
    @PutMapping("/edit")
    public CarModel updateEmployee(@RequestBody CarModel carModel) throws ErrorService {
        try {
            return carService.update(carModel);
        }catch (Exception e){
            throw new ErrorService("wops");
        }
    }

}
