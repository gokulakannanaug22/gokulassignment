package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PricingServiceRequest.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestRequest {

	/**
	 * 
	 */
	@JsonProperty("Array")
	List<List<Integer>> array;
	
	/**
	 * @return
	 */
	public List<List<Integer>> getArray() {
		return array;
	}

	/**
	 * @param array1
	 */
	public void setArray(List<List<Integer>> array) {
		this.array = array;
	}

}
