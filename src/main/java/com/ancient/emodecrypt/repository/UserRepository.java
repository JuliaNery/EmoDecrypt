package com.ancient.emodecrypt.repository;

import com.ancient.emodecrypt.entity.UserDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableMongoRepositories
public interface UserRepository extends MongoRepository<UserDocument, ObjectId> {
    Optional<UserDocument> findByEmail(String email);

}
