package com.kodlamaio.invantoryServer.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.invantoryServer.business.abstracts.BrandServise;
import com.kodlamaio.invantoryServer.business.requests.create.CreateBrandRequest;
import com.kodlamaio.invantoryServer.business.requests.update.UpdateBrandRequest;
import com.kodlamaio.invantoryServer.business.responses.create.CreateBrandResponse;
import com.kodlamaio.invantoryServer.business.responses.get.GetAllBrandResponse;
import com.kodlamaio.invantoryServer.business.responses.update.UpdateBrandResponse;
import com.kodlamaio.invantoryServer.dataAccess.BrandRepository;
import com.kodlamaio.invantoryServer.entites.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandServise {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandResponse> getAll() {
		List<Brand> brands = this.brandRepository.findAll();

		List<GetAllBrandResponse> response = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class))
				.collect(Collectors.toList());

		return response;
	}

	@Override
	public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
		checkIfBrandExistsByName(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		brand.setId(UUID.randomUUID().toString());

		this.brandRepository.save(brand);

		CreateBrandResponse createBrandResponse = this.modelMapperService.forResponse().map(brand,
				CreateBrandResponse.class);
		return createBrandResponse;
	}

	@Override
	public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
		checkIfBrandExistsById(updateBrandRequest.getId());
		checkIfBrandExistsByName(updateBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		UpdateBrandResponse updateBrandResponse = this.modelMapperService.forResponse().map(brand,
				UpdateBrandResponse.class);
		return updateBrandResponse;
	}

	@Override
	public void delete(String id) {
		checkIfBrandExistsById(id);
		this.brandRepository.deleteById(id);

	}

	private void checkIfBrandExistsByName(String name) {
		Brand currentBrand = this.brandRepository.findByName(name);
		if (currentBrand != null) {
			throw new BusinessException("BRAND.EXISTS");
		}
	}

	private void checkIfBrandExistsById(String id) {
		if (this.brandRepository.findById(id).get() == null) {
			throw new BusinessException("BRAND.NOT.EXİSTS");
		}
	}

}