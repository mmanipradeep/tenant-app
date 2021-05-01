package com.tenantMaintenance.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="RENTAL_HOUSE")
public class RentalHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String houseNo;
    private String houseName;
    private String houseArea;
    private Date createdBy;
    private String createdDate;
    private Date updatedDate;
    private String updatedBy;

}
