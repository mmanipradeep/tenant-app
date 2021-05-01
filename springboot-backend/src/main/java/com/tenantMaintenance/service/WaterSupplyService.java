package com.tenantMaintenance.service;

import com.tenantMaintenance.exception.ResourceNotFoundException;
import com.tenantMaintenance.model.WaterSupply;
import com.tenantMaintenance.repository.WaterSupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WaterSupplyService {

    @Autowired
    WaterSupplyRepository waterSupplyRepository;

    public List<WaterSupply> getWaterSupplyDetails(){
        return waterSupplyRepository.findAll();
    }

    public WaterSupply createWaterSupply(WaterSupply waterSupply){
        return waterSupplyRepository.save(waterSupply);
    }

    public ResponseEntity<WaterSupply> getWaterSupplyById(Long id){
        WaterSupply waterSupply=waterSupplyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Water Supply not exist with id :" + id));
        return ResponseEntity.ok(waterSupply);
    }

    public ResponseEntity<WaterSupply> updateWaterSupply(Long id , WaterSupply waterSupply){
        WaterSupply waterSupplyFromDB = waterSupplyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Water Supply  not exist with id :" + id));
        waterSupplyFromDB.setUpdatedDate(waterSupply.getUpdatedDate());
        waterSupplyFromDB.setUpdatedBy(waterSupply.getUpdatedBy());
        WaterSupply updWaterSupply = waterSupplyRepository.save(waterSupplyFromDB);
        return ResponseEntity.ok(updWaterSupply);
    }

    public ResponseEntity<Map<String, Boolean>> deleteWaterSupply(Long id){
        WaterSupply waterSupply = waterSupplyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Water Supply not exist with id :" + id));
        waterSupplyRepository.delete(waterSupply);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
