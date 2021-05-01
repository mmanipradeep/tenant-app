package com.tenantMaintenance.service;

import com.tenantMaintenance.exception.ResourceNotFoundException;
import com.tenantMaintenance.model.EBConnection;
import com.tenantMaintenance.repository.EBConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EBConnectionService {

    @Autowired
    EBConnectionRepository eBConnectionRepository;

    public List<EBConnection> getEBConnectionDetails(){
        return eBConnectionRepository.findAll();
    }

    public EBConnection createEBConnection(EBConnection ebConnection){
        return eBConnectionRepository.save(ebConnection);
    }

    public ResponseEntity<EBConnection> getEBDetailsById(Long id){
        EBConnection ebConnection=eBConnectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EB Connection not exist with id :" + id));
        return ResponseEntity.ok(ebConnection);
    }

    public ResponseEntity<EBConnection> updateEBDetails(Long id , EBConnection ebConnection){
        EBConnection ebConnectionFromDB = eBConnectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EB Connections not exist with id :" + id));
        ebConnectionFromDB.setUpdatedDate(ebConnection.getUpdatedDate());
        ebConnectionFromDB.setUpdatedBy(ebConnection.getUpdatedBy());
        EBConnection updEBConnection = eBConnectionRepository.save(ebConnectionFromDB);
        return ResponseEntity.ok(updEBConnection);
    }

    public ResponseEntity<Map<String, Boolean>> deleteEBDetails(Long id){
        EBConnection ebConnection = eBConnectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EB Connection not exist with id :" + id));
        eBConnectionRepository.delete(ebConnection);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
