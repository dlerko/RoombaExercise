package com.pleasecompile;

import org.junit.runners.Suite;

import com.pleasecompile.service.RoomblaJsonDeserialiserTest;
import com.pleasecompile.service.RoomblaRequestControllerTest;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({CardinalDirectionTest.class, RoomblaRequestTest.class, RoomblaTest.class, RoomTest.class, RoomblaJsonDeserialiserTest.class, RoomblaRequestControllerTest.class})
public class RoomblaSuite {

}
