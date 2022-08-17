package com.zaga.taxibooking.enities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GenerationType;

@Entity
@Table(name = "passenger_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer phoneNo;
    private String emailAddress;
    private String pickUpLocation;
    private String vehicleType;
    private float fare;
    private String bookingStatus;
    private String destination;
    private String region;

}
