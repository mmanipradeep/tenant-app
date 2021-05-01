package com.tenantMaintenance.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="PROPERTY_TAX")
public class PropertyTax {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String propertyTaxNo;
    private String propertyTaxOwnerName;
    private String areaName;
    private Date createdBy;
    private String createdDate;
    private Date updatedDate;
    private String updatedBy;
}
