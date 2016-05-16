package com.pleasecompile.service;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.pleasecompile.RoomblaRequestAWS;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class RoomblaRequestControllerTest {
	
	  private MockMvc mvc;
	 
	  @Before
	  public void setUp() throws Exception {
	    mvc = MockMvcBuilders.standaloneSetup(new RoomblaRequestController()).build();
	  }

	  @Test
	  public void canRequestRoombla() throws Exception {
		  
			RoomblaRequestAWS awsRequest = new RoomblaRequestAWS();
			awsRequest.setCoords(new int [] {1, 2});
			awsRequest.setInstructions(new String[]{"NNESEESWNWW"});
			awsRequest.setPatches(new int [][] {{1,0}, {2,2},{2,3}});
			awsRequest.setRoomSize(new int []{5,5});
			
			RoomblaRequest roombla = new RoomblaRequest(awsRequest);
		    ObjectMapper mapper = new ObjectMapper();
		    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		    String requestJson=ow.writeValueAsString(roombla);
		    String content = "{\"roomSize\":[5,5],\"coords\":[1,2],\"patches\":[[1,0],[2,2],[2,3]],\"instructions\":\"NNESEESWNWW\"}";
		    String expectedResponse = "{\"coords\":[1,3],\"patches\":1}";
		    ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/cleanroom", requestJson).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string(equalTo(expectedResponse)));
	  }
	}