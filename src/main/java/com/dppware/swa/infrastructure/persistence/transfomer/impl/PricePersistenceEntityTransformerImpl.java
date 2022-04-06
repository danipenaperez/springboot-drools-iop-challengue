package com.dppware.swa.infrastructure.persistence.transfomer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dppware.swa.domain.entity.PriceDomainEntity;
import com.dppware.swa.infrastructure.persistence.entity.Price;
import com.dppware.swa.infrastructure.persistence.transfomer.PricePersistenceEntityTransformer;
import com.dppware.swa.infrastructure.persistence.transfomer.mapper.PricePersistenceEntityMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PricePersistenceEntityTransformerImpl implements PricePersistenceEntityTransformer{

	PricePersistenceEntityMapper pricePersistenceEntityMapper;
	
	public PriceDomainEntity from(Price price) {
		return pricePersistenceEntityMapper.from(price);
	}

	@Override
	public List<PriceDomainEntity> from(List<Price> prices) {
		 
		if(!CollectionUtils.isEmpty(prices)) {
			List<PriceDomainEntity> transformed = new ArrayList<PriceDomainEntity>();
			prices.forEach(pe-> transformed.add(pricePersistenceEntityMapper.from(pe)));
			return transformed;
		}
		return null;
	}
}
