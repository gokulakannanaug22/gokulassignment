package com.example.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.error.ApplicationError;
import com.example.error.InputError;
import com.example.model.RestRequest;

@RunWith(MockitoJUnitRunner.class)
public class MakeOneArrayServiceImplTest {

	/**
	 * MakeOneArrayServiceImpl
	 */
	public MakeOneArrayServiceImpl makeOneArrayService;
	/**
	 * restRequest
	 */
	public RestRequest restRequest;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		makeOneArrayService = new MakeOneArrayServiceImpl();
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
	 * testRetrieveOneArray
	 * @throws Exception
	 */
	@Test
	public void testRetrieveOneArray() throws Exception{
		makeOneArrayService.retrieveOneArray(restRequest);
		assertNotNull(restRequest);
		assertEquals("Array size", 3, restRequest.getArray().size());
		List<Integer> newList = new ArrayList<>();
		newList.add(1);
		newList.add(2);
		newList.add(3);
		newList.add(4);
		newList.add(5);
		newList.add(6);
		newList.add(11);
		assertEquals("Return Result", newList, makeOneArrayService.retrieveOneArray(restRequest));
	}
	
	/**
	 * testRetrieveOneArrayNullRequest
	 * @throws Exception
	 */
	@Test(expected=InputError.class)
	public void testRetrieveOneArrayNullRequest() throws Exception{
		restRequest = null;
		makeOneArrayService.retrieveOneArray(restRequest);
	}
	
	/**
	 * testRetrieveOneArray
	 * @throws Exception
	 */
	@Test
	public void testRetrieveOneArrayReplicate() throws Exception{
		List<List<Integer>> array = new ArrayList<>();
		List<Integer> innerArray = new ArrayList<>();
		innerArray.add(1);
		innerArray.add(2);
		innerArray.add(1);
		innerArray.add(1);		
		array.add(innerArray);
		
		innerArray = new ArrayList<>();
		innerArray.add(3);
		innerArray.add(3);
		innerArray.add(3);
		innerArray.add(3);		
		array.add(innerArray);
		restRequest = new RestRequest();
		restRequest.setArray(array);
		
		makeOneArrayService.retrieveOneArray(restRequest);
		assertNotNull(restRequest);
		assertEquals("Array size", 2, restRequest.getArray().size());
		List<Integer> newList = new ArrayList<>();
		newList.add(1);
		newList.add(2);
		newList.add(3);
		assertEquals("Return Result", newList, makeOneArrayService.retrieveOneArray(restRequest));
	}
}
