package org.selflearning.msa.products.dtos;

public class ProductPriceRequest {

	private Double goldWeight;

	private String goldPurity;

	private Double pearlsWeight;

	public Double getGoldWeight() {
		return goldWeight;
	}

	public void setGoldWeight(Double goldWeight) {
		this.goldWeight = goldWeight;
	}

	public String getGoldPurity() {
		return goldPurity;
	}

	public void setGoldPurity(String goldPurity) {
		this.goldPurity = goldPurity;
	}

	public Double getPearlsWeight() {
		return pearlsWeight;
	}

	public void setPearlsWeight(Double pearlsWeight) {
		this.pearlsWeight = pearlsWeight;
	}

}
