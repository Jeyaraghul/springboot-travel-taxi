package com.zaga.taxibooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zaga.taxibooking.enities.TaxiDriverDetails;

public interface DriverRepo extends JpaRepository<TaxiDriverDetails, Long> {
    // @Query(value = "SELECT vehicle_type,region_active FROM taxi_driver_details")
    // public List<?> availabilityCheck();

    @Query("SELECT c FROM TaxiDriverDetails c WHERE  vehicle_type = ?1 AND region_active = ?2 AND availability = ?3")
    List<TaxiDriverDetails> availablityCheck(String vehicleType, String regionActive, String availability);
}
