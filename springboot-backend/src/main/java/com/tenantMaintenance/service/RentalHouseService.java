package com.tenantMaintenance.service;

import com.tenantMaintenance.exception.ResourceNotFoundException;
import com.tenantMaintenance.model.RentalHouse;
import com.tenantMaintenance.repository.RentalHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RentalHouseService {

    @Autowired
    RentalHouseRepository rentalHouseRepository;

    public List<RentalHouse> getRentalHouseDetails(){
        return rentalHouseRepository.findAll();
    }

    public RentalHouse createRentalHouse(RentalHouse rentalHouse){
        return rentalHouseRepository.save(rentalHouse);
    }

    public ResponseEntity<RentalHouse> getRentalHouseById(Long id){
        RentalHouse ebConnection=rentalHouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental House not exist with id :" + id));
        return ResponseEntity.ok(ebConnection);
    }

    public ResponseEntity<RentalHouse> updateRentalHouse(Long id , RentalHouse rentalHouse){
        RentalHouse rentalHouseFromDB = rentalHouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental House not exist with id :" + id));
        rentalHouseFromDB.setUpdatedDate(rentalHouse.getUpdatedDate());
        rentalHouseFromDB.setUpdatedBy(rentalHouse.getUpdatedBy());
        RentalHouse updRentalHouse = rentalHouseRepository.save(rentalHouseFromDB);
        return ResponseEntity.ok(updRentalHouse);
    }

    public ResponseEntity<Map<String, Boolean>> deleteRentalHouse(Long id){
        RentalHouse rentalHouse = rentalHouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("rental House not exist with id :" + id));
        rentalHouseRepository.delete(rentalHouse);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
