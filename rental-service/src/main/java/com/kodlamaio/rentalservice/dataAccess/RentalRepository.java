package com.kodlamaio.rentalservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.rentalservice.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental, String> {
	Rental findByCarId(String carId);


}
