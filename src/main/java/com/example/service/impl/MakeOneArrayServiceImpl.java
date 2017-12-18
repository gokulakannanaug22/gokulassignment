/**
 * Copyright comments
 */
package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.error.ExceptionErrorMessage;
import com.example.error.InputError;
import com.example.model.RestRequest;
import com.example.service.MakeOneArrayService;
/**
 * This is the Implementation class for MakeOneArrayService
 */
@Service
public class MakeOneArrayServiceImpl implements MakeOneArrayService{

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * retrieves the array into one single array by eliminating duplicates and sort
	 * retrieveOneArray.
	 *
	 * @param List<Integer>
	 * @return the List
	 */
	@Override
	public List<Integer> retrieveOneArray(RestRequest restRequest) {

		log.info("Implementing retrieveOneArray in MakeOneArrayServiceImpl");

		if(!Optional.ofNullable(restRequest).isPresent()) {
			throw new InputError(ExceptionErrorMessage.newObject()
					.developerMessage("Input Validation Failed because of incorrect array input"));
		}
		List<Integer> combinedList = new ArrayList<>();
		for(List<Integer> newList : restRequest.getArray()) {
			combinedList.addAll(newList);
		}
		List<Integer> newList = new ArrayList<>();
		for (Integer x : combinedList){
			if (!newList.contains(x))
				newList.add(x);
		}
		return newList;
	}


}
