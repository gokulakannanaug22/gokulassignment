package com.example.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.error.ApplicationError;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ReverseWordsImplTest {

	/**
	 * 
	 */
	public ReverseWordsImpl reverseWords;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		reverseWords = new ReverseWordsImpl();
	}
	
	/**
	 * testretrieveReverseWords
	 * @throws Exception
	 */
	@Test
	public void testretrieveReverseWords() throws Exception{
		String sentence = "How are you";
		reverseWords.retrieveReverseWords(sentence);
		assertEquals("String Compare", "woH era uoy ", reverseWords.retrieveReverseWords(sentence));
		assertNotNull(reverseWords.retrieveReverseWords(sentence));
		assertEquals("Input String", "How are you", sentence);
	}
	
	/**
	 * testretrieveReverseWordsEmpty
	 * @throws Exception
	 */
	@Test
	public void testretrieveReverseWordsEmpty() throws Exception{
		String sentence = " ";
		reverseWords.retrieveReverseWords(sentence);
		assertEquals("String Compare", "", reverseWords.retrieveReverseWords(sentence));
		assertNotNull(reverseWords.retrieveReverseWords(sentence));
		assertEquals("Input String", " ", sentence);
	}
	
	/**
	 * testretrieveReverseWordsEmptySpace
	 * @throws Exception
	 */
	@Test(expected=ComparisonFailure.class)
	public void testretrieveReverseWordsEmptySpace() throws Exception{
		String sentence = "";
		reverseWords.retrieveReverseWords(sentence);
		assertEquals("String Compare", "", reverseWords.retrieveReverseWords(sentence));
		assertNotNull(reverseWords.retrieveReverseWords(sentence));
		assertEquals("Input String", "", sentence);
	}
	
	/**
	 * testretrieveReverseWordsNull
	 * @throws Exception
	 */
	@Test(expected=ApplicationError.class)
	public void testretrieveReverseWordsNull() throws Exception{
		String sentence = null;
		reverseWords.retrieveReverseWords(sentence);
	}
}
