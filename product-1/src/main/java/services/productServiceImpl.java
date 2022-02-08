package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.product;
import repositories.prodRepository;

@Service
public class productServiceImpl implements prodService {
	

	
	@Autowired
	private prodRepository prodRepo;

	
	//return un produit par son ID
	@Override
	public product findProductById(String prodId) {
		
		product p= prodRepo.findById(prodId).get();
		return p;
	}
	

	
	//returner tous les produits de la BD
	@Override
	public List<product> getAllProducts() {
		// TODO Auto-generated method stub
		return prodRepo.findAll();
	}
	
	@Override
	public List<product> getVerified(){
		return prodRepo.findByVerified(true);
	
	}
	@Override
	public List<product> getSoldProd(){
		return prodRepo.findBySold(true);
	
	}
	

	

}
