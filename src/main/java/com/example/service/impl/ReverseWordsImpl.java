/**
 * Copyright comments
 */
package com.example.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.error.ApplicationError;
import com.example.error.ExceptionErrorMessage;
import com.example.service.ReverseWordsService;
/**
 * This is the Implementation class for Reverse Words Controller
 */
@Service
public class ReverseWordsImpl implements ReverseWordsService{

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Retrieve Reverse Words
	 *
	 * @param inputSentence
	 * @return the reverseString
	 */
	@Override
	public String retrieveReverseWords(String inputSentence) {
		if(!Optional.ofNullable(inputSentence).isPresent()) {
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.developerMessage("Input Validation Failed because of incorrect string type"));
		}
		String[] words = inputSentence.split(" ");			         
		String reverseString = "";	
		for (int i = 0; i < words.length; i++) 
		{
			String word = words[i];			             
			String reverseWord = "";			             
			for (int j = word.length()-1; j >= 0; j--) 
			{
				reverseWord = reverseWord + word.charAt(j);
			}			             
			reverseString = reverseString + reverseWord + " ";
		}			         
		log.info(inputSentence);
		log.info(reverseString);

		return reverseString;
	}

}