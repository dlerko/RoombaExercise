package com.pleasecompile.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pleasecompile.service.RoomblaRequest;

public interface RoomblaRequestRepository extends MongoRepository<RoomblaRequest, String>{

}
