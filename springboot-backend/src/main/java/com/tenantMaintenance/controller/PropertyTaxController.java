package com.tenantMaintenance.controller;

import com.tenantMaintenance.model.PropertyTax;
import com.tenantMaintenance.service.PropertyTaxService;
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
public class PropertyTaxController {

    @Autowired
    private PropertyTaxService propertyTaxService;

    @GetMapping("/propertyTaxes")
    public List<PropertyTax> getAllPropertyTax(){
        return propertyTaxService.getPropertyTaxDetails();
    }

    @PostMapping("/propertyTaxes")
    public PropertyTax createTenant(@RequestBody PropertyTax propertyTax) {
        return propertyTaxService.createPropertyTax(propertyTax);
    }

    // get employee by id rest api
    @GetMapping("/propertyTaxes/{id}")
    public ResponseEntity<PropertyTax> getPropertyTaxById(@PathVariable Long id) {
        return propertyTaxService.getPropertyTaxById(id);
    }

    // update employee rest api
    @PutMapping("/propertyTaxes/{id}")
    public ResponseEntity<PropertyTax> updatePropertyTax(@PathVariable Long id,
                                                         @RequestBody PropertyTax propertyTax){
        return propertyTaxService.updatePropertyTax(id, propertyTax);
    }

    // delete employee rest api
    @DeleteMapping("/propertyTaxes/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePropertyTax(@PathVariable Long id){
        return propertyTaxService.deletePropertyTax(id);
    }
}
