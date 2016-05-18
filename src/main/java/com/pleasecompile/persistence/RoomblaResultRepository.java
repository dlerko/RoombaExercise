package com.pleasecompile.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pleasecompile.service.RoomblaResult;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomblaResultRepository extends MongoRepository<RoomblaResult, String>{

}
