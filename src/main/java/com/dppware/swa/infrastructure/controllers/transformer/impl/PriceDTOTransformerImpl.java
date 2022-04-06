package com.dppware.swa.infrastructure.controllers.transformer.impl;

import org.springframework.stereotype.Component;

import com.dppware.swa.api.model.PriceResponse;
import com.dppware.swa.domain.entity.PriceDomainEntity;
import com.dppware.swa.infrastructure.controllers.transformer.PriceDTOTransformer;
import com.dppware.swa.infrastructure.controllers.transformer.mapper.PriceDTOMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PriceDTOTransformerImpl implements PriceDTOTransformer{

	PriceDTOMapper priceDTOMapper;
	
	public PriceResponse from(PriceDomainEntity priceBean){
		return priceDTOMapper.from(priceBean);
	}
	
}
