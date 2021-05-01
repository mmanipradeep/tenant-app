package com.tenantMaintenance.repository;

import com.tenantMaintenance.model.WaterSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterSupplyRepository extends JpaRepository<WaterSupply,Long> {
}
