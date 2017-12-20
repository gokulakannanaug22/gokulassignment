 /**
 * Copyright comments
 */
package com.example.validator;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.error.ApplicationError;
import com.example.error.ExceptionErrorMessage;
import com.example.error.InputError;

/**
 * This Error is thrown when code has encountered any situation which can not be handled and program can not continue to
 * complete user request. These situations are due to gaps and issues in the program logic.
 * @author gokulakannanv
 *
 */
@Component
public class InputValidator {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * This method validates the input
	 * validate
	 * @param number
	 * @return boolean
	 */
	public boolean validate(long number) {
		if(Optional.ofNullable(number).isPresent() && number>=0) {
			if( String.valueOf(number).length()>2) {
				throw new InputError(ExceptionErrorMessage.newObject()
						.displayDeveloperMessage("Input Validation Failed because of max input"));
			}
			log.info("Input Successfully Validated");		
			return true;
		}
		else {
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.displayDeveloperMessage("Input Validation Failed because of incorrect input"));
		}
	}

	/**
	 * This method validates the input
	 * validate
	 * @param sideA, sideB, sideC
	 * @return boolean
	 */
	public boolean validate(int sideA, int sideB, int sideC) {
		if(Optional.ofNullable(sideA).isPresent() && Optional.ofNullable(sideB).isPresent() && Optional.ofNullable(sideC).isPresent() ) {
			checkNonNegative(sideA, sideB, sideC);
			log.info("Input Successfully Validated");		
			return true;
		}
		else {
			throw new InputError(ExceptionErrorMessage.newObject()
					.displayDeveloperMessage("Input Validation Failed because of incorrect input"));
		}
	}

	/**
	 * checkNonNegative
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 */
	private void checkNonNegative(int sideA, int sideB, int sideC) {
		if(sideA<0 || sideB<0 || sideC<0) {
			throw new InputError(ExceptionErrorMessage.newObject()
					.displayDeveloperMessage("Input Validation Failed because of negative input"));
		}
	}
}
