/**
 * Copyright comments
 */
package com.example.controller;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.RestResponse;
import com.example.service.impl.FibonacciServiceImpl;


import javax.ws.rs.core.MediaType;
/**
 * This is the Controller for Fibonacci Sequence
 */
@RestController
@RequestMapping("/api")
@Produces({ MediaType.APPLICATION_JSON })
public class FibonacciController {

/**
 * fibonacciService
 */
@Autowired
FibonacciServiceImpl fibonacciService;

/** The log. */
private final Logger log = LoggerFactory.getLogger(this.getClass());

/**
 * Retrieve Fibonacci Sequence.
 *
 * @param n
 * @return the rest response
 */
@GET
@RequestMapping("/Fibonacci")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@ResponseBody
public RestResponse retrieveFibonacciSequence(  @QueryParam("n")
final long n, HttpServletResponse  response) {
	
	log.info("[FibonacciController Called. Invoke getFibonacciSequence]");
	
	response.addHeader("pragma", "no-cache");
	response.addHeader("expires", "-1");
	
	return RestResponse.build(() -> {
		return fibonacciService.retrieveFibonacciSequence(n);
	});
	
}
}
