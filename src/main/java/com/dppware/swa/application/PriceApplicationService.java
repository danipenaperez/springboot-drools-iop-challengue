package com.dppware.swa.application;

import java.time.OffsetDateTime;

import com.dppware.swa.application.exception.NotFoundPriceException;
import com.dppware.swa.domain.entity.PriceDomainEntity;


public interface PriceApplicationService {

	public PriceDomainEntity getPrice(OffsetDateTime onDate, Integer brandId, Integer productId) throws NotFoundPriceException;

}
