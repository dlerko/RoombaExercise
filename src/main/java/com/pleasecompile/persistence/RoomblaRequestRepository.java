package com.pleasecompile.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pleasecompile.service.RoomblaRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomblaRequestRepository extends MongoRepository<RoomblaRequest, String>{

}
