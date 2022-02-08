package services;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entities.product;


@FeignClient(name = "PRODUCT1-SERVICE")
public interface prodService {


	//returner un produit par son ID
	product findProductById(String prodId);

	//returner tous les produits de la BD
		List<product> getAllProducts();

		List<product> getVerified();

		List<product> getSoldProd();




	
	
	
	




}


