package com.dppware.swa.infrastructure.controllers;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.dppware.swa.api.PriceApiDelegate;
import com.dppware.swa.api.model.PriceResponse;
import com.dppware.swa.application.PriceApplicationService;
import com.dppware.swa.domain.entity.PriceDomainEntity;
import com.dppware.swa.infrastructure.controllers.transformer.PriceDTOTransformer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class PriceAPIDelegateController implements PriceApiDelegate {
	

	PriceDTOTransformer priceDTOTransformer;
	
	PriceApplicationService priceApplicationService;


	@Secured({"ROLE_USER", "ROLE_ADMIN"}) 
	public ResponseEntity<PriceResponse> getPrice(OffsetDateTime onDate, Integer brandId, Integer productId) {
		
		PriceDomainEntity priceSelected = priceApplicationService.getPrice(onDate, brandId, productId);
		
		return new ResponseEntity<>(priceDTOTransformer.from(priceSelected),HttpStatus.OK);

	}
}
