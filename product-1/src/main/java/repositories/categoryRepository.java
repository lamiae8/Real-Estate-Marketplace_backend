package repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import entities.category;

@Repository
public interface categoryRepository extends MongoRepository<category, String>{

	

}
