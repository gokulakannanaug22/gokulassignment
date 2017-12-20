package com.example.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.error.ApplicationError;
import com.example.validator.InputValidator;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class) 
public class FibonacciServiceImplTest {

	/**
	 * fibonacciService
	 */
	@InjectMocks
	public FibonacciServiceImpl fibonacciService;
	
	/**
	 * mInputValidator
	 */
	@Mock
	public InputValidator mInputValidator;
	
	/**
	 * inputValidator
	 */
	@InjectMocks
	public InputValidator inputValidator;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
	}
	
	/**
	 * testGroupFibonacciList
	 * @throws Exception
	 */
	@Test
	public void testGroupFibonacciList() throws Exception{
		long number = 10;
		when(mInputValidator.validate(new Long(10))).thenReturn(true);		
		fibonacciService.retrieveFibonacciSequence(number);
		assertEquals("Compare Result", 55, fibonacciService.retrieveFibonacciSequence(number));
		assertEquals("Input", 10, number);
		assertNotNull(fibonacciService.retrieveFibonacciSequence(number));
	}
	
	/**
	 * testGroupFibonacciListInput
	 * @throws Exception
	 */
	@Test
	public void testGroupFibonacciListInput() throws Exception{
		long number = 0;
		fibonacciService.retrieveFibonacciSequence(number);
		assertEquals(0, fibonacciService.retrieveFibonacciSequence(number));
		assertEquals("Input", 0, number);
		assertNotNull(fibonacciService.retrieveFibonacciSequence(number));
	}
	
	/**
	 * testGroupFibonacciListNull
	 * @throws Exception
	 */
	@Test (expected=ApplicationError.class)
	public void testGroupFibonacciListNull() throws Exception{
		long number= -10;
		when(inputValidator.validate(new Long(-10))).thenReturn(true);
		assertEquals("Input", -10, number);
		fibonacciService.retrieveFibonacciSequence(number);
	}
}
