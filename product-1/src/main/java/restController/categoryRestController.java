package restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.category;
import lombok.RequiredArgsConstructor;
import repositories.categoryRepository;
import request.productRequest;
import services.categoryService;

@RequestMapping("/product/category")

@RequiredArgsConstructor

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class categoryRestController {
	
	@Autowired
	public categoryService catService;
	
	@Autowired
	public categoryRepository catRepository;
	
	@GetMapping("/getAll")
	public List<category> listCategory() {
		return (catService.getAllCategories() );
		
	}
	
	@GetMapping("/get/{id}")
	public category getCategory(@PathVariable("id") String id) {
		return (catService.getCategory(id) );
		
	}
	
	
     @PostMapping("/create")
     public String addCategory(String label) {
    	 category c= new category(label);
    	 catRepository.save(c);
    	 return "category registered successfully!";
     }
     
     @PostMapping("/update/{id}")
     public category updateCategory(@PathVariable("id") String id,String label) {
    	 category c=catRepository.findById(id).get();
    	 c.setLabel(label);
    	 catRepository.save(c);
    	 System.out.println("category updated successfully!");
    	 return c;
    	 
     }
     
     @PostMapping("/delete/{id}")
     public String deleteCategory(@PathVariable("id") String id) {
    	 category c=catRepository.findById(id).get();
    	 catRepository.delete(c);
    	 return "category deleted successfully!";
     }


}
