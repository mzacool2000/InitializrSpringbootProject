package com.example.myCar.service;

import com.example.myCar.entity.Maintenance;
import com.example.myCar.entity.Vehicle;
import com.example.myCar.model.MaintenanceModel;
import com.example.myCar.repository.MaintenanceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MaintenanceService {

    @Autowired
    private VehiculoService vehiculoService;
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    ModelMapper mapper = new ModelMapper();

    /**
     *  this function create a Maintenance with an vehicle in db
     * @param maintenanceModel
     * @return MaintenanceModel
     * @throws ErrorService
     */
    public MaintenanceModel crate(MaintenanceModel maintenanceModel)throws ErrorService{
        try{
            validatedMaintenance(maintenanceModel);
            Maintenance maintenance = mapper.map(maintenanceModel, Maintenance.class);
            return mapper.map(maintenanceRepository.save(maintenance),MaintenanceModel.class);
        } catch (Exception e){
           throw new ErrorService("dont cant save maintenance");
        }
    }

    /**
     * this function update an maintenance in bd
     * @param maintenanceModel
     * @return
     * @throws ErrorService
     */
    public MaintenanceModel update(MaintenanceModel maintenanceModel) throws ErrorService{
        validatedMaintenance(maintenanceModel);
        if (maintenanceModel.getMaintenanceId() == null){
            throw new ErrorService("the id not can be null");
        }
            Optional<Maintenance> response = maintenanceRepository.findById(maintenanceModel.getMaintenanceId());
            if (response.isPresent()){
                try{
                    return mapper.map(maintenanceRepository.save(
                            mapper.map(maintenanceModel,Maintenance.class)),MaintenanceModel.class);
                }catch (Exception e){
                    throw new ErrorService("the maintenance dont can be saved");
                }

            } else {
                throw new ErrorService("the maintenance not was found");
            }

    }

    /**
     * this function deleted a existent maintenance
     * @param id
     * @throws ErrorService
     */
    public void deleted(String id) throws ErrorService{
        if (id == null){
            throw new ErrorService("you need a maintenance id");
        }
        Optional<Maintenance> response = maintenanceRepository.findById(id);
        if (response.isPresent()){
            try {
                maintenanceRepository.delete(response.get());
            } catch (Exception e){
                throw new ErrorService("the maintenance id " + id + "dont can´t be deleted");
            }
        } else {
            throw new ErrorService("the maintenance id " + id + "dont exist");
        }

    }

    /**
     * this function return all maintenances
     * @return a list a maintenance
     */
    public List<MaintenanceModel> findAll(){
        List<Maintenance> maintenances = maintenanceRepository.findAll();
        List<MaintenanceModel> maintenanceModels = new ArrayList<>();
        for (Maintenance maintenance: maintenances) {
            maintenanceModels.add(mapper.map(maintenance,MaintenanceModel.class));
        }
        return maintenanceModels;
    }

    /**
     * This function returns a maintenance if exist
     * @param id
     * @return maintenanceModel
     * @throws ErrorService
     */
    public MaintenanceModel find(String id) throws ErrorService{
        if (id == null){
            throw new ErrorService("the id don´t cant be empty");
        }
        Optional<Maintenance> response = maintenanceRepository.findById(id);
        if (response.isPresent()){
            return mapper.map(response.get(), MaintenanceModel.class);
        }else{
            throw new ErrorService("the maintenance dont found");
        }
    }


    /**
     * this function validated a maintenance
     * @param maintenanceModel
     * @throws ErrorService
     */
    public void validatedMaintenance(MaintenanceModel maintenanceModel) throws ErrorService {
        boolean areDateCreate = maintenanceModel.getDateCreate() != null;
        boolean areNotes = maintenanceModel.getNotes() != null;
        if (maintenanceModel.getVehicleModel() != null) {
            vehiculoService.ValidateVehicle(mapper.map(maintenanceModel.getVehicleModel(), Vehicle.class));
        }
        if (!(areDateCreate && areNotes)) {
            throw new ErrorService("someting is missing");
        }
    }

    }

