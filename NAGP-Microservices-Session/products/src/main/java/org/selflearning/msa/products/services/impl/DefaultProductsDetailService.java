package org.selflearning.msa.products.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.selflearning.msa.products.dtos.ProductPriceRequest;
import org.selflearning.msa.products.entities.Product;
import org.selflearning.msa.products.services.ProductsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DefaultProductsDetailService implements ProductsDetailService {
	
	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Resource
	private RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public Product getProductByDesignNumber(String designNumber){
		
		Optional<Product> resultproduct=getAllProducts().stream().filter(p ->designNumber.equals(p.getDesignNumber())).findFirst();
		if(resultproduct.isPresent()) {
			
			
			String baseUrl = loadBalancerClient.choose("prices").getUri().toString() + "/price";
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Double> response = null;
			ProductPriceRequest ppr=new ProductPriceRequest();
			ppr.setGoldPurity(resultproduct.get().getGoldPurity());
			ppr.setGoldWeight(resultproduct.get().getGoldWeight());
			ppr.setPearlsWeight(resultproduct.get().getPearlsWeight());
			try {
				response = restTemplate.exchange(baseUrl, HttpMethod.GET,new HttpEntity<ProductPriceRequest>(ppr), Double.class);
			} catch (Exception ex) {
				System.out.println(ex);
			}
			System.out.println(response.getBody());
			resultproduct.get().setPrice(response.getBody());
			//resultproduct.get().setPrice(restTemplate.getForObject("http://products/products/test", Double.class));
			
			return resultproduct.get();
		}
		return null;
	}
	
	protected List<Product> getAllProducts(){
		List<Product> products= new ArrayList<>();
		products.add(new Product("001", "Men Ring", 7.08D, "22", 0.0D));
		products.add(new Product("002", "Women Ring", 6.50D, "22", 0.0D));
		products.add(new Product("003", "Men Chain", 17.06D, "22", 0.0D));
		products.add(new Product("004", "Women Chain", 15.33D, "22", 0.0D));
		products.add(new Product("005", "Women Bangle", 22.76D, "22", 0.0D));
		products.add(new Product("006", "Women Earings", 10.54D, "22", 4.35D));
		products.add(new Product("007", "Women Necklace", 33.52D, "22", 12.40D));
		return products;
	}
	
}
