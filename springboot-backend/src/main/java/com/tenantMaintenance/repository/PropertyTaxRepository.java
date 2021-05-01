package com.tenantMaintenance.repository;

import com.tenantMaintenance.model.PropertyTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PropertyTaxRepository extends JpaRepository<PropertyTax,Long> {
}
