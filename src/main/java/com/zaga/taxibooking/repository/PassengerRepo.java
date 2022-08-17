package com.zaga.taxibooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaga.taxibooking.enities.PassengerDetails;

public interface PassengerRepo extends JpaRepository<PassengerDetails, Long> {

}
