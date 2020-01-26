package org.selflearning.msa.prices.controller;

import javax.annotation.Resource;

import org.selflearning.msa.prices.dtos.ProductData;
import org.selflearning.msa.prices.services.PriceCalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/price")
public class PriceController {

	@Resource
	PriceCalculationService priceCalculationService;

	@GetMapping
	Double getProductDetails(@PathVariable(name = "product") ProductData productData) {
		return priceCalculationService.calculateProductPrice(productData);
	}

}
