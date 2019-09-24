package com.intelligix.WorkshopMongo.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.intelligix.WorkshopMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
