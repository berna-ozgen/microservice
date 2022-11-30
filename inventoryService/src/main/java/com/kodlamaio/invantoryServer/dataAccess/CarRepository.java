package com.kodlamaio.invantoryServer.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.invantoryServer.entites.Car;

public interface CarRepository extends JpaRepository<Car, String> {
	Car findByPlate(String plate);
}