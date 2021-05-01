package com.tenantMaintenance.service;

import java.util.*;

import com.tenantMaintenance.exception.ResourceNotFoundException;
import com.tenantMaintenance.model.Tenant;
import com.tenantMaintenance.repository.TenantDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TenantDetailsService {
    
    @Autowired
    TenantDetailsRepository tenantDetailsRepository;

    public List<Tenant> getTenantDetails(){
        return tenantDetailsRepository.findAll();
    }

    public Tenant createTenant(Tenant tenant){
        try{
            tenant.setStatus("A");
            tenant.setCreatedBy("SYSTEM");
            tenant.setCreatedDate(new Date());
           if(tenant.getTenantName()!=null){
            return tenantDetailsRepository.save(tenant);
           }
        }catch(Exception e){

        }
        return tenant ;
    }

    public ResponseEntity<Tenant> getTenantById(Long id){
        Tenant tenant=tenantDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not exist with id :" + id));
         return ResponseEntity.ok(tenant);
    }

    public ResponseEntity<Tenant> updateTenantDetails(Long id , Tenant tenant){

        Optional<Tenant> tenantOptional = tenantDetailsRepository.findById(id);
        if (!tenantOptional.isPresent())
            return ResponseEntity.notFound().build();
        tenant.setId(id);
        tenant.setUpdatedDate(new Date());
        tenant.setUpdatedBy("SYSTEM");
		Tenant updateTenant = tenantDetailsRepository.save(tenant);
		return ResponseEntity.ok(updateTenant);
    }

    public ResponseEntity<Map<String, Boolean>> deleteTenantDetails(Long id){
        Tenant tenantFromDB = tenantDetailsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Tenant not exist with id :" + id));
        tenantFromDB.setStatus("D");
        tenantDetailsRepository.save(tenantFromDB);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

   

}
