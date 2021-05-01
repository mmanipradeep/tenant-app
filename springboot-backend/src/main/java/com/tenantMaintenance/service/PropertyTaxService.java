package com.tenantMaintenance.service;

import com.tenantMaintenance.exception.ResourceNotFoundException;
import com.tenantMaintenance.model.PropertyTax;
import com.tenantMaintenance.repository.PropertyTaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PropertyTaxService {

    @Autowired
    PropertyTaxRepository propertyTaxRepository;

    public List<PropertyTax> getPropertyTaxDetails(){
        return propertyTaxRepository.findAll();
    }

    public PropertyTax createPropertyTax(PropertyTax ebConnection){
        return propertyTaxRepository.save(ebConnection);
    }

    public ResponseEntity<PropertyTax> getPropertyTaxById(Long id){
        PropertyTax propertyTax=propertyTaxRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property Tax not exist with id :" + id));
        return ResponseEntity.ok(propertyTax);
    }

    public ResponseEntity<PropertyTax> updatePropertyTax(Long id , PropertyTax propertyTax){
        PropertyTax propertyTaxFromDB = propertyTaxRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property Tax not exist with id :" + id));
        propertyTaxFromDB.setUpdatedDate(propertyTax.getUpdatedDate());
        propertyTaxFromDB.setUpdatedBy(propertyTax.getUpdatedBy());
        PropertyTax updPropertyTax = propertyTaxRepository.save(propertyTaxFromDB);
        return ResponseEntity.ok(updPropertyTax);
    }

    public ResponseEntity<Map<String, Boolean>> deletePropertyTax(Long id){
        PropertyTax propertyTaxFromDB = propertyTaxRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property Tax  not exist with id :" + id));
        propertyTaxRepository.delete(propertyTaxFromDB);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
