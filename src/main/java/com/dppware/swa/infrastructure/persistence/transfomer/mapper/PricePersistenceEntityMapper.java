package com.dppware.swa.infrastructure.persistence.transfomer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dppware.swa.domain.entity.PriceDomainEntity;
import com.dppware.swa.infrastructure.persistence.entity.Price;

@Mapper(componentModel = "spring")
public interface PricePersistenceEntityMapper {

	@Mapping(source = "priceId.brandId", target = "brandId")
    @Mapping(source = "priceId.productId", target = "productId")
	@Mapping(source = "priceId.rateId", target = "rateId")
	PriceDomainEntity from(Price price);
}
