package org.selflearning.msa.prices.services;

import org.selflearning.msa.prices.dtos.ProductData;

public interface PriceCalculationService {

	Double calculateProductPrice(ProductData productData);
}
