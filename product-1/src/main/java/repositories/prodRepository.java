package repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import entities.product;
import feign.Param;

@Repository
public interface prodRepository extends MongoRepository<product, String> {

	

	@Query(value = "SELECT u FROM product u WHERE u.userId IN :user")
	List<product> findProdByUser(@Param("user") Collection<String> user);
	
	List<product> findAllByUserId(String id);
	@Query("{'verified' : true}")
	 List<product> findByVerified(Boolean verified);
	 
	 @Query("{'solde' : true}")
		 List<product> findBySold(Boolean solde);
		
}

		
		
