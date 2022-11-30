package com.kodlamaio.invantoryServer.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.invantoryServer.entites.Brand;

public interface BrandRepository extends JpaRepository<Brand, String> {
	Brand findByName(String name);


}