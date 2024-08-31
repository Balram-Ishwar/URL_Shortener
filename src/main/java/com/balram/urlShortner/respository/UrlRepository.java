package com.balram.urlShortner.respository;

import com.balram.urlShortner.enities.UrlEntity;

//import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<UrlEntity, String> {
	boolean existsById(String id);
	
}
