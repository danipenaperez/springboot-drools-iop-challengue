package com.dppware.swa.domain.utils;

import java.util.Comparator;
import java.util.List;

import com.dppware.swa.domain.entity.PriceDomainEntity;

/**
 * Drools version does not support Java 8 operations on mvel definitions.
 * This Class encapsulate all util functions used on drools executions import.
 * @author dpena
 *
 */
public class DomainJavaUtils {

	public static void orderbyPriorityAsc(List<PriceDomainEntity> priceList) {
		priceList.sort(Comparator.comparingLong(PriceDomainEntity::getPriority).reversed());
	}
}
