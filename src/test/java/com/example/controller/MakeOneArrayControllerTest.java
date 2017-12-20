package com.example.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.model.RestRequest;
import com.example.service.impl.MakeOneArrayServiceImpl;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MakeOneArrayControllerTest {


	/**
	 * HttpServletResponse
	 */
	@Mock
	public HttpServletResponse response;
	
	/**
	 * fibonacciService
	 */
	@Mock
	public MakeOneArrayServiceImpl makeOneArrayService;
	
	/**
	 * fibonacciController
	 */
	@InjectMocks
	public MakeOneArrayController makeOneArrayController;
	
	/**
	 * restRequest
	 */
	public RestRequest restRequest;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		restRequest = new RestRequest();
		restRequest = new RestRequest();
		List<List<Integer>> array = new ArrayList<>();
		List<Integer> innerArray = new ArrayList<>();
		innerArray.add(1);
		innerArray.add(2);
		innerArray.add(3);
		innerArray.add(4);		
		array.add(innerArray);
		
		innerArray = new ArrayList<>();
		innerArray.add(3);
		innerArray.add(4);
		innerArray.add(5);
		innerArray.add(6);		
		array.add(innerArray);
		
		innerArray = new ArrayList<>();
		innerArray.add(6);
		innerArray.add(1);
		innerArray.add(3);
		innerArray.add(11);		
		array.add(innerArray);
		
		restRequest.setArray(array);
	}
	
	/**
	 * testretrieveFibonacciSequence
	 * @throws Exception
	 */
	@Test
	public void testretrieveFibonacciSequence() throws Exception{
		makeOneArrayController.retrieveOneArray(restRequest, response);
		assertEquals("Inpur Compare", 3, restRequest.getArray().size());
		assertNotNull(restRequest);
		assertNotNull(makeOneArrayController.retrieveOneArray(restRequest, response));
	}
	
	/**
	 * testretrieveFibonacciSequenceFailure
	 * @throws Exception
	 */
	@Test(expected=NullPointerException.class)
	public void testretrieveFibonacciSequenceFailure() throws Exception{
		makeOneArrayController = new MakeOneArrayController();
		when(makeOneArrayService.retrieveOneArray(restRequest)).thenReturn(new ArrayList<>());
		makeOneArrayController.retrieveOneArray(restRequest, response);
	}

}
