/**
 * Copyright comments
 */
package com.example.service.impl;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.error.ApplicationError;
import com.example.error.ExceptionErrorMessage;
import com.example.service.FibonacciService;
import com.example.validator.InputValidator;
/**
 * This is the Implementation class for Fibonacci Controller
 * @author gokulakannanv
 *
 */
@Service
public class FibonacciServiceImpl implements FibonacciService{

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * inputValidator
	 */
	@Autowired
	public InputValidator inputValidator;

	/**
	 * This method is used to retrieve the fibonacci sequence by validating the input
	 * retrieveFibonacciSequence
	 *
	 * @param number
	 * @return the groupFibonacciList
	 */
	@Override
	public long retrieveFibonacciSequence(long number) {
		log.info("Fibonacci Sequence Implementation");
		long result = 0;
			if(inputValidator.validate(number)) {
				try {
				result = groupFibonacciList(number);
				}catch (Exception e) {
					log.error("Exception occurred when retrieving Fibonacci Sequence");
					throw new ApplicationError(ExceptionErrorMessage.newObject()
							.displayDeveloperMessage("Exception occurred when retrieving Fibonacci Sequence").cause(e));
				}
			}
		return result;
	}

	/**
	 * This method is used to retrieve the fibonacci sequence
	 * groupFibonacciList
	 * @param number
	 * @return long
	 */
	private long groupFibonacciList(long number){

		return Stream.iterate(new long[] {1, 1}, fibonacci -> new long[] {fibonacci[1], fibonacci[0] + fibonacci[1]})
				.limit(number)
				.reduce((firstValue, nextValue) -> nextValue)
				.get()[0];
		
	}

}
