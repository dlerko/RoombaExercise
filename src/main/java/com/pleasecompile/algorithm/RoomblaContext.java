package com.pleasecompile.algorithm;

import com.pleasecompile.service.RoomblaRequest;
import com.pleasecompile.service.RoomblaResult;

public class RoomblaContext {

	private RoomblaStrategy strategy;
	
	public RoomblaContext(RoomblaStrategy strategy) {
		this.strategy = strategy;
	}
	
	public RoomblaResult executeStrategy(RoomblaRequest request) {
		return strategy.execute(request);
	}
}
