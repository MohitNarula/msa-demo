package org.selflearning.msa.prices.controller;

import javax.annotation.Resource;

import org.selflearning.msa.prices.services.PriceCalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/price")
public class PriceController {

	@Resource
	PriceCalculationService priceCalculationService;

	@GetMapping
	Double getProductPrice(@RequestParam(name = "goldWeight") Double goldWeight,
			@RequestParam(name = "goldPurity") String goldPurity,
			@RequestParam(name = "pearlsWeight") Double pearlsWeight) {
		return priceCalculationService.calculateProductPrice(goldWeight,goldPurity,pearlsWeight);
	}
	
	

}
