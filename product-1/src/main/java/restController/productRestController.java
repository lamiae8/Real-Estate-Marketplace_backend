package restController;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.product;
import lombok.RequiredArgsConstructor;
import openFeign.userRestClient;
import repositories.prodRepository;
import request.productRequest;
import services.prodService;



@RequestMapping("/product")

@RequiredArgsConstructor

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class productRestController {

	@Autowired
	private prodService productService ;
	 

	@Autowired
	private prodRepository prodRepo ;
	
	@Autowired
	private userRestClient userfeign;
	
	

	@GetMapping("/getProduct/{id}")
	public product getProduct(@PathVariable("id") String id) {
		product p=prodRepo.findById(id).get();
		return p;
	}
	
	
	@GetMapping("/user-products")
    public List <product> getproductByUserId(HttpServletRequest request ){
		String id=userfeign.getUserId(request.getHeader("Authorization"));
		return prodRepo.findAllByUserId(id);
//        return new ResponseEntity<List<product>>(productService.getProductByUser(userId),  null);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public String create( @RequestBody productRequest prodRequest,HttpServletRequest request){
		String id=userfeign.getUserId(request.getHeader("Authorization"));

		product prod = new product(
				prodRequest.getLabel(),
				 prodRequest.getTitle(),
				 prodRequest.getLocation(),
				 prodRequest.getSurface(),
				 prodRequest.getPrice(),
				 prodRequest.getDiscription(),
				 prodRequest.isSolde(),
				 prodRequest.isVerified(),
				id,
				prodRequest.getSellerAddress(),
				prodRequest.getImages(),
				 prodRequest.getCategory()
				 
				 );

prodRepo.save(prod);
		return "Real Estate registered successfully!";

		
		
	}
	
	//retourner la liste de tous les produits
	@GetMapping("/allProducts")
    public List<product> getAllproducts(){
        return (productService.getAllProducts() );
    }
	
	@PostMapping("/verify/{id}")
	public String verify(@PathVariable("id") String id) {
		product p= prodRepo.findById(id).get();
		p.setVerified(true);
		prodRepo.save(p);
		return "product verified successfully!";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		product p= prodRepo.findById(id).get();
		
		prodRepo.delete(p);
		return "product deleted successfully!";
	}
	
	@PostMapping("/solde/{id}")
	public product solde(@PathVariable("id") String id) {
		product p= prodRepo.findById(id).get();
		p.setSolde(true);
	return 	prodRepo.save(p);
		
	}
	
	
	@GetMapping("/isVerified")
	public List<product> isVerified(){
		return prodRepo.findByVerified(true);
	}
	
	@GetMapping("/isSold")
	public List<product> isSold(){
		return prodRepo.findBySold(true);
	}
	
}
