package com.example.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.service.impl.ReverseWordsImpl;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ReverseWordsControllerTest {


	/**
	 * HttpServletResponse
	 */
	@Mock
	public HttpServletResponse response;
	
	/**
	 * reverseWords
	 */
	@Mock
	public ReverseWordsImpl reverseWords;
	
	/**
	 * reverseWordsController
	 */
	@InjectMocks
	public ReverseWordsController reverseWordsController;
	
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
		String inputSentence = "How are you";
		when(reverseWords.retrieveReverseWords(inputSentence)).thenReturn("woH era uoy ");
		reverseWordsController.retrieveReverseWords(inputSentence, response);
		assertNotNull(reverseWordsController.retrieveReverseWords(inputSentence, response));
		assertEquals("Service Result", "woH era uoy ", reverseWords.retrieveReverseWords(inputSentence));
	}
	
	/**
	 * testretrieveFibonacciSequenceGenericInput
	 * @throws Exception
	 */
	@Test
	public void testretrieveFibonacciSequenceGenericInput() throws Exception{
		when(reverseWords.retrieveReverseWords(new String())).thenReturn(new String());
		reverseWordsController.retrieveReverseWords(new String(), response);
		assertNotNull(reverseWordsController.retrieveReverseWords(new String(), response));
	}
	
	/**
	 * testretrieveFibonacciSequenceFailure
	 * @throws Exception
	 */
	@Test(expected=NullPointerException.class)
	public void testretrieveFibonacciSequenceFailure() throws Exception{
		reverseWordsController = new ReverseWordsController();
		when(reverseWords.retrieveReverseWords(new String())).thenReturn(new String());
		reverseWordsController.retrieveReverseWords(new String(), response);
	}

}
