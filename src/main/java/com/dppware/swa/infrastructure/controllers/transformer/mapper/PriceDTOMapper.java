package com.dppware.swa.infrastructure.controllers.transformer.mapper;

import org.mapstruct.Mapper;

import com.dppware.swa.api.model.PriceResponse;
import com.dppware.swa.domain.entity.PriceDomainEntity;

@Mapper(componentModel = "spring")
public interface PriceDTOMapper {

	PriceResponse from(PriceDomainEntity priceBean);

}
