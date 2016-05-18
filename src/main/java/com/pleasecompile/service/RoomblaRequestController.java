package com.pleasecompile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pleasecompile.algorithm.RoomblaContext;
import com.pleasecompile.algorithm.RoomblaHashSetStrategy;
import com.pleasecompile.persistence.RoomblaRequestRepository;
import com.pleasecompile.persistence.RoomblaResultRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages="com.pleasecompile.persistence")
@RestController
public class RoomblaRequestController {

	@Autowired
	private RoomblaRequestRepository requestRepository;

	@Autowired
	private RoomblaResultRepository resultRepository;

	@RequestMapping(value = "/cleanroom", method= RequestMethod.POST)
	public ResponseEntity<RoomblaResult> cleanRoom(@RequestBody RoomblaRequest request) {

		//Persist request
		//TODO Uncomment to test persistence, needs local mongodb
//		requestRepository.save(request);

    	RoomblaContext roomblaContext = new RoomblaContext(new RoomblaHashSetStrategy());
    	RoomblaResult result = roomblaContext.executeStrategy(request);

    	//Persist result
    	//TODO Uncomment to test persistence, needs local mongodb
//    	resultRepository.save(result);

		return new ResponseEntity<RoomblaResult>(result, HttpStatus.OK);
	}
}
