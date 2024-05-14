package com.ancient.emodecrypt.repository;

import com.ancient.emodecrypt.entity.MassaDadosEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableMongoRepositories

public interface MassaDadosRepository extends MongoRepository<MassaDadosEntity, ObjectId> {
    Optional<MassaDadosEntity> findById(ObjectId id);
}
