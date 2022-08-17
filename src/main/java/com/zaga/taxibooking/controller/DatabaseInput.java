package com.zaga.taxibooking.controller;

import org.springframework.web.bind.annotation.RestController;

import com.zaga.taxibooking.enities.PassengerDetails;
import com.zaga.taxibooking.enities.TaxiDriverDetails;
import com.zaga.taxibooking.repository.DriverRepo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class DatabaseInput {

    @Autowired
    private DriverRepo driverRepo;

    @PostMapping("/createTaxiDriverDetails")
    public ResponseEntity<TaxiDriverDetails> createTaxiDatabase(@RequestBody TaxiDriverDetails taxiDriver) {
        try {
            return new ResponseEntity<>(driverRepo.save(taxiDriver), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}
