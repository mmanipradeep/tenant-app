package com.tenantMaintenance.repository;

import com.tenantMaintenance.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantDetailsRepository extends JpaRepository<Tenant,Long>{
    
}
