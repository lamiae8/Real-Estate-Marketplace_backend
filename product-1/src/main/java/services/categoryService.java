package services;

import java.util.List;

import entities.category;

public interface categoryService {
	
	//returner tous les produits de la BD
			List<category> getAllCategories();
			category getCategory(String catId);
			
}
