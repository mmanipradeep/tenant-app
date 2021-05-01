package com.tenantMaintenance.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="EB_SERVICE")
public class EBConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String ebConnectionNo;
    private String ebConnectionOwnerName;
    private String areaName;
    private Date createdBy;
    private String createdDate;
    private Date updatedDate;
    private String updatedBy;

}
