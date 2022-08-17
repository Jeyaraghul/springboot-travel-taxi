package com.zaga.taxibooking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.taxibooking.enities.PassengerDetails;
import com.zaga.taxibooking.enities.TaxiDriverDetails;
import com.zaga.taxibooking.repository.DriverRepo;

@RestController
public class AvailabilityCheck {

    @Autowired
    private DriverRepo repo;

    @PostMapping("/avail")
    public ResponseEntity<?> getAvailability(@RequestBody PassengerDetails passenger) {
        try {
            List<TaxiDriverDetails> data = repo.availablityCheck(passenger.getVehicleType(), passenger.getRegion(),
                    "A");
            // TaxiDriverDetails datas = data.indexOf(0);
            return new ResponseEntity<TaxiDriverDetails>(data.get(0), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> bookingConfirmation(@RequestBody TaxiDriverDetails t) {
        try {
            // if(passenger.getBookingStatus() == "confirm")

            Optional<TaxiDriverDetails> taxi = repo.findById(t.getId());
            if (taxi.isPresent()) {
                TaxiDriverDetails data = taxi.get();
                data.setAvailability("NA");
                return new ResponseEntity<TaxiDriverDetails>(repo.save(data), HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return null;
    }

}
