/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myCar.repository;

import com.example.myCar.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chiri
 */
@Repository
public interface TruckRepository extends JpaRepository<Truck, String>{
    
}
