package com.tenantMaintenance.repository;

import com.tenantMaintenance.model.EBConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EBConnectionRepository extends JpaRepository<EBConnection,Long> {
}
