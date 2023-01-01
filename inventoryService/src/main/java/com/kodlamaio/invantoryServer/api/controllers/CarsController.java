package com.kodlamaio.invantoryServer.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.common.utilities.results.DataResult;
import com.kodlamaio.common.utilities.results.Result;
import com.kodlamaio.invantoryServer.business.abstracts.CarService;
import com.kodlamaio.invantoryServer.business.requests.create.CreateCarRequest;
import com.kodlamaio.invantoryServer.business.requests.update.UpdateCarRequest;
import com.kodlamaio.invantoryServer.business.responses.create.CreateCarResponse;
import com.kodlamaio.invantoryServer.business.responses.get.GetAllCarResponse;
import com.kodlamaio.invantoryServer.business.responses.get.GetCarResponse;
import com.kodlamaio.invantoryServer.business.responses.update.UpdateCarResponse;

import lombok.AllArgsConstructor;

@RequestMapping("/api/cars")
@RestController
@AllArgsConstructor
public class CarsController {
	private CarService carService;

	@PutMapping
	public ResponseEntity<?> update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {
		DataResult<UpdateCarResponse> result = this.carService.update(updateCarRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable @Valid String id) {
		Result result = this.carService.delete(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Valid CreateCarRequest createCarRequest) {
		DataResult<CreateCarResponse> result = this.carService.add(createCarRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		DataResult<List<GetAllCarResponse>> result = this.carService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("/{carId}")
	public ResponseEntity<?> getById(@PathVariable String carId) {
		DataResult<GetCarResponse> result = this.carService.getById(carId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
