package com.zaga.taxibooking.enities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "taxi_Driver_Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxiDriverDetails {
    private String vehicleType;
    private String vehicleNo;
    private String driverName;
    private String regionActive;
    private String driverPhoneNo;
    private String availability;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
