package com.tenantMaintenance.controller;

import com.tenantMaintenance.model.EBConnection;
import com.tenantMaintenance.service.EBConnectionService;
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
public class EBConnectionController {

    @Autowired
    private EBConnectionService ebConnectionService;

    @GetMapping("/ebConnections")
    public List<EBConnection> getAllEBConnections(){
        return ebConnectionService.getEBConnectionDetails();
    }

    @PostMapping("/ebConnections")
    public EBConnection createTenant(@RequestBody EBConnection ebConnection) {
        return ebConnectionService.createEBConnection(ebConnection);
    }

    // get employee by id rest api
    @GetMapping("/ebConnections/{id}")
    public ResponseEntity<EBConnection> getConnectionById(@PathVariable Long id) {
        return ebConnectionService.getEBDetailsById(id);
    }

    // update employee rest api
    @PutMapping("/ebConnections/{id}")
    public ResponseEntity<EBConnection> updateConnection(@PathVariable Long id,
                                                         @RequestBody EBConnection ebConnectionDetails){
        return ebConnectionService.updateEBDetails(id, ebConnectionDetails);
    }

    // delete employee rest api
    @DeleteMapping("/ebConnections/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEBConnection(@PathVariable Long id){
        return ebConnectionService.deleteEBDetails(id);
    }
}
