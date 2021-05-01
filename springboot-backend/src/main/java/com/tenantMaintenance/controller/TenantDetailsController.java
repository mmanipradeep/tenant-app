package com.tenantMaintenance.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.tenantMaintenance.model.Tenant;
import com.tenantMaintenance.repository.TenantDetailsRepository;
import com.tenantMaintenance.service.TenantDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tenants")
//@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:4200")
public class TenantDetailsController {
    
    @Autowired
    private TenantDetailsService tenantDetailsService;

	@Autowired
	private TenantDetailsRepository tenantDetailsRepository;

	@GetMapping("/error")
	public String customError() {
		return "The link you followed may be broken, or the page may have been removed.";
	}


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Tenant> getTenantDetails() {

		return tenantDetailsRepository.findAll();
	}

	@PostMapping
	public Tenant createTenant( @RequestBody Tenant tenant) {

		return tenantDetailsService.createTenant(tenant);
	}
	
	// get employee by id rest api
	@GetMapping("/tenant/{id}")
	public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {

		return tenantDetailsService.getTenantById(id);
	}


	@PutMapping("/{id}")
	public ResponseEntity<?> updateTenant(@RequestBody Tenant tenant, @PathVariable long id) {

		tenantDetailsService.updateTenantDetails(id, tenant);
		//tenantDetailsRepository.save(tenant);
		return ResponseEntity.noContent().build();
	}
	
	// delete employee rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTenant(@PathVariable Long id){
		return tenantDetailsService.deleteTenantDetails(id);
	}
}
