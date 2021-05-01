package com.tenantMaintenance.controller;



import com.tenantMaintenance.model.WaterSupply;
import com.tenantMaintenance.service.WaterSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:3000")
public class WaterSupplyController {

    @Autowired
    private WaterSupplyService waterSupplyService;

    @GetMapping("/waterSupply")
    public List<WaterSupply> getAllWaterSupplyDetails(){
        return waterSupplyService.getWaterSupplyDetails();
    }

    @PostMapping("/waterSupply")
    public WaterSupply createTenant(@RequestBody WaterSupply waterSupply) {
        return waterSupplyService.createWaterSupply(waterSupply);
    }

    // get employee by id rest api
    @GetMapping("/waterSupply/{id}")
    public ResponseEntity<WaterSupply> getTenantById(@PathVariable Long id) {
        return waterSupplyService.getWaterSupplyById(id);
    }

    // update employee rest api
    @PutMapping("/waterSupply/{id}")
    public ResponseEntity<WaterSupply> updateTenant(@PathVariable Long id, @RequestBody WaterSupply waterSupplyDetails){
        return waterSupplyService.updateWaterSupply(id, waterSupplyDetails);
    }

    // delete employee rest api
    @DeleteMapping("/waterSupply/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTenant(@PathVariable Long id){
        return waterSupplyService.deleteWaterSupply(id);
    }
}
