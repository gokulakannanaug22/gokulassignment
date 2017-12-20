package com.example.controller;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import com.example.service.impl.FibonacciServiceImpl;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class FibonacciControllerTest {

	/**
	 * HttpServletResponse
	 */
	@Mock
	public HttpServletResponse response;
	
	/**
	 * fibonacciService
	 */
	@Mock
	public FibonacciServiceImpl fibonacciService;
	
	/**
	 * fibonacciController
	 */
	@InjectMocks
	public FibonacciController fibonacciController;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		
	}
	
	/**
	 * testretrieveFibonacciSequenceValid
	 * @throws Exception
	 */
	@Test
	public void testretrieveFibonacciSequenceValid() throws Exception{
		when(fibonacciService.retrieveFibonacciSequence(10)).thenReturn((long) 55);
		fibonacciController.retrieveFibonacciSequence(10, response);
		assertNotNull(fibonacciController.retrieveFibonacciSequence(10, response));
		assertEquals("Service Result", 55, fibonacciService.retrieveFibonacciSequence(10));
	}
	
	/**
	 * testretrieveFibonacciSequenceGenericInput
	 * @throws Exception
	 */
	@Test
	public void testretrieveFibonacciSequenceGenericInput() throws Exception{
		when(fibonacciService.retrieveFibonacciSequence(new Long(10))).thenReturn(new Long(55));
		fibonacciController.retrieveFibonacciSequence(new Long(10), response);
		assertNotNull(fibonacciController.retrieveFibonacciSequence(new Long(10), response));
	}
	
	/**
	 * testretrieveFibonacciSequenceFailure
	 * @throws Exception
	 */
	@Test(expected=NullPointerException.class)
	public void testretrieveFibonacciSequenceFailure() throws Exception{
		fibonacciController = new FibonacciController();
		when(fibonacciService.retrieveFibonacciSequence(new Long(10))).thenReturn(new Long(55));
		fibonacciController.retrieveFibonacciSequence(new Long(10), response);
	}
}
