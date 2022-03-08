package com.example.myCar.controller;

import com.example.myCar.entity.Truck;
import com.example.myCar.model.TruckModel;
import com.example.myCar.repository.TruckRepository;
import com.example.myCar.service.ErrorService;
import com.example.myCar.service.TruckService;
import enums.TruckType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/truck")
public class TruckCpntroller {
        @Autowired
        private TruckService truckService;

        @GetMapping("/all")
        public List<TruckModel> allTrucks() {
            return truckService.findAll();
        }
        @GetMapping("/{id}")
        public TruckModel Truck(@PathVariable("id") String id) throws ErrorService {
            try{
                return truckService.find(id);
            }catch (Exception e){
                return null;
            }
        }
        @GetMapping("/delete/{id}")
        public String delete(@PathVariable ("id") String id) throws ErrorService {
            try{
                truckService.delete(id);
                return "truck id " + id + " was deleted";
            }catch (Exception e){
                return null;
            }
        }
        @PostMapping("/add")
        public TruckModel createTruck(@RequestBody TruckModel truckModel)throws ErrorService{
            try{
                return truckService.create(truckModel);
            }catch (Exception e){
                throw new ErrorService("wops");
            }
        }
        @PutMapping("/edit")
        public TruckModel updateEmployee(@RequestBody TruckModel truckModel) throws ErrorService {
            try {
                return truckService.update(truckModel);
            }catch (Exception e){
                throw new ErrorService("wops");
            }
        }

    }
