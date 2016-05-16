package com.pleasecompile.algorithm;

import com.pleasecompile.service.RoomblaRequest;
import com.pleasecompile.service.RoomblaResult;

public interface RoomblaStrategy {

	public RoomblaResult execute(RoomblaRequest request);
}
