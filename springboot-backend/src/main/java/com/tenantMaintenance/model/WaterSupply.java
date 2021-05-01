package com.tenantMaintenance.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="WATER_SERVICE")
public class WaterSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String waterConnectionNo;
    private String waterConnectionOwnerName;
    private String areaName;
    private Date createdBy;
    private String createdDate;
    private Date updatedDate;
    private String updatedBy;
}
