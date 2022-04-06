package com.dppware.swa.infrastructure.controllers.transformer;

import com.dppware.swa.api.model.PriceResponse;
import com.dppware.swa.domain.entity.PriceDomainEntity;

public interface PriceDTOTransformer {
	
	PriceResponse from(PriceDomainEntity priceDomainEntity);

}
