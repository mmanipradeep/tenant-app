package com.tenantMaintenance.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name="TENANT")
public class Tenant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String tenantName;
    private BigDecimal advanceAmount;
    private BigDecimal monthlyRent;
    private Date onBoardDate;
    private String status;
    private Date separationDate;
    private Date createdDate;
    private Date updatedDate;
    private String createdBy;
    private String updatedBy;

}
