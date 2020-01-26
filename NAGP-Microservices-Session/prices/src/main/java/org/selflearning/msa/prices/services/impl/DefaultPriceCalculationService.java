package org.selflearning.msa.prices.services.impl;

import org.selflearning.msa.prices.dtos.ProductData;
import org.selflearning.msa.prices.services.PriceCalculationService;
import org.springframework.stereotype.Service;

@Service
public class DefaultPriceCalculationService implements PriceCalculationService {

	@Override
	public Double calculateProductPrice(ProductData productData) {
		// TODO Auto-generated method stub
		return 20.0D;
	}

}
