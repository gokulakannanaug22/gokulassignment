/**
 * Copyright comments
 */
package com.example.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.error.ApplicationError;
import com.example.error.ExceptionErrorMessage;
import com.example.service.TriangleService;
import com.example.validator.InputValidator;
/**
 * To determine the type of triangle
 * @author gokulakannanv
 *
 */
@Service
public class TriangleServiceImpl implements TriangleService{

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * inputValidator
	 */
	@Autowired
	public InputValidator inputValidator;

	/**
	 * Retrieve Triangle Type.
	 *
	 * @param a, b, c
	 * @return the getTriangleType
	 */

	@Override
	public String retrieveTriangleType(int sideA, int sideB, int sideC) {
		log.info("Triangle Type");
		String triangleType = null;
		if (inputValidator.validate(sideA, sideB, sideC)) {
			try {
			triangleType = triangleType(sideA, sideB, sideC);
			}catch (Exception e) {
				log.error("Exception occurred when retrieving Triangle Type");
				throw new ApplicationError(ExceptionErrorMessage.newObject()
						.displayDeveloperMessage("Exception occurred when retrieving Triangle Type").cause(e));
			}
		}
		return triangleType;
	}

	/**
	 * triangleType
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 * @return
	 */
	public String triangleType(int sideA, int sideB, int sideC) {
		String triangleType = null;
		// If all sides are equal
		if(sideA==sideB && sideB==sideC) {
			triangleType = "Equilateral";
		}
		// if any two sides are equal
		else if ((sideA==sideB && sideB!=sideC ) || (sideA!=sideB && sideC==sideA) || (sideC==sideB && sideC!=sideA)) {
			triangleType = "Isosceles";
		}
		// if none of the sides are equal
		else if(sideA!=sideB && sideB!=sideC && sideC!=sideA) {
			triangleType = "Scalene";
		}
		return triangleType;
	}


}
