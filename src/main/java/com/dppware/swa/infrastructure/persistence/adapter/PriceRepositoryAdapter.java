package com.dppware.swa.infrastructure.persistence.adapter;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dppware.swa.application.port.PriceRepositoryPort;
import com.dppware.swa.domain.entity.PriceDomainEntity;
import com.dppware.swa.infrastructure.persistence.entity.Price;
import com.dppware.swa.infrastructure.persistence.repository.PriceRepository;
import com.dppware.swa.infrastructure.persistence.transfomer.PricePersistenceEntityTransformer;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

	PricePersistenceEntityTransformer pricePersistenceEntityTransformer;
	
	PriceRepository priceRepository;
	
	@Override
	public List<PriceDomainEntity> findActive(Long brandId, Long productId, OffsetDateTime searchDate) {
		
		List<Price> pricesFound = priceRepository.findActive(brandId.longValue(), productId.longValue(), searchDate);
		System.out.println("He encontrado en bbdd "+pricesFound);
		
		return pricePersistenceEntityTransformer.from(pricesFound);
	}

}
