package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.category;

import repositories.categoryRepository;


@Service
public class categoryserviceImpl implements categoryService{
	
	@Autowired
	private categoryRepository catRepo;
	
	//returner tous les produits de la BD
	   @Override
		public List<category> getAllCategories() {
			// TODO Auto-generated method stub
			return catRepo.findAll();
		}
		@Override
		public category getCategory(String catId) {
			return catRepo.findById(catId).get();
		}
		
		
}
