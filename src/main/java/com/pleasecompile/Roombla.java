package com.pleasecompile;

import com.amazonaws.services.lambda.runtime.Context;
import com.pleasecompile.algorithm.RoomblaContext;
import com.pleasecompile.algorithm.RoomblaHashSetStrategy;
import com.pleasecompile.service.RoomblaRequest;
import com.pleasecompile.service.RoomblaResult;

public class Roombla {

    // Our lambda function handler, outside of the scope of this exercise
    public String myHandler(RoomblaRequestAWS input, Context context) {
    	
//    	MongoClient mongoClient = new MongoClient( "localhost" );
    	RoomblaRequest request = new RoomblaRequest(input);
    	RoomblaContext roomblaContext = new RoomblaContext(new RoomblaHashSetStrategy());
    	RoomblaResult result = roomblaContext.executeStrategy(request);
    	
      return result.toString();
    }
}
