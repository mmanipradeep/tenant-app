package com.tenantMaintenance.controller;

import com.tenantMaintenance.model.RentalHouse;
import com.tenantMaintenance.service.RentalHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@EnableAutoConfiguration
//@CrossOrigin(origins = "http://localhost:3000")
public class RentalHouseController {

    @Autowired
    private RentalHouseService rentalHouseService;

    @GetMapping("/rentalHouses")
    public List<RentalHouse> getAllRentalHouses(){
        return rentalHouseService.getRentalHouseDetails();
    }

    @PostMapping("/rentalHouses")
    public RentalHouse createRental(@RequestBody RentalHouse rentalHouse) {
        return rentalHouseService.createRentalHouse(rentalHouse);
    }

    // get employee by id rest api
    @GetMapping("/rentalHouses/{id}")
    public ResponseEntity<RentalHouse> getRentalHouseById(@PathVariable Long id) {
        return rentalHouseService.getRentalHouseById(id);
    }

    // update employee rest api
    @PutMapping("/rentalHouses/{id}")
    public ResponseEntity<RentalHouse> updateRentalHouses(@PathVariable Long id,
                                                         @RequestBody RentalHouse rentalHouse){
        return rentalHouseService.updateRentalHouse(id, rentalHouse);
    }

    // delete employee rest api
    @DeleteMapping("/rentalHouses/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRentalHouse(@PathVariable Long id){
        return rentalHouseService.deleteRentalHouse(id);
    }

}
