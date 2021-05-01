package com.tenantMaintenance.repository;

import com.tenantMaintenance.model.RentalHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalHouseRepository extends JpaRepository<RentalHouse,Long> {
}
