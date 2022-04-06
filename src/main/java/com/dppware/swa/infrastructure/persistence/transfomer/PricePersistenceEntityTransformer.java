package com.dppware.swa.infrastructure.persistence.transfomer;

import java.util.List;

import com.dppware.swa.domain.entity.PriceDomainEntity;
import com.dppware.swa.infrastructure.persistence.entity.Price;

public interface PricePersistenceEntityTransformer {

	List<PriceDomainEntity> from(List<Price> prices);
}
