package com.dppware.swa.application.impl;


import java.time.OffsetDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dppware.swa.application.PriceApplicationService;
import com.dppware.swa.application.exception.NotFoundPriceException;
import com.dppware.swa.application.port.PriceRepositoryPort;
import com.dppware.swa.domain.entity.PriceCalculatorOperation;
import com.dppware.swa.domain.entity.PriceDomainEntity;
import com.dppware.swa.domain.service.PriceCalculatorDomainService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class PriceApplicationServiceImpl implements PriceApplicationService{

	PriceRepositoryPort priceRepositoryPort;

	PriceCalculatorDomainService priceCalculatorDomainService;

	@Transactional
	public PriceDomainEntity getPrice(OffsetDateTime onDate, Integer brandId, Integer productId) {
		// Find for Repository Source data
		List<PriceDomainEntity> pricesFound = priceRepositoryPort.findActive(brandId.longValue(), productId.longValue(), onDate);

		System.out.println("Y he encontrado en bbdd "+ pricesFound);
		if(CollectionUtils.isEmpty(pricesFound)) {
			throw new NotFoundPriceException();
		}
		// Get the Price by Priority is a bussines Rule. Execute domain rules and get
		// output
		PriceCalculatorOperation operation = PriceCalculatorOperation.builder().input(pricesFound).build();
		priceCalculatorDomainService.calculatePrice(operation);

		
		return operation.getOutput();
		

	}

}
