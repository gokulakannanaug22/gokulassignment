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

import com.example.service.impl.TriangleServiceImpl;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TriangleControllerTest {


	/**
	 * HttpServletResponse
	 */
	@Mock
	public HttpServletResponse response;
	
	/**
	 * triangleService
	 */
	@Mock
	public TriangleServiceImpl triangleService ;
	
	/**
	 * triangleController
	 */
	@InjectMocks
	public TriangleController triangleController;
	
	/**
	 * 
	 */
	public int msideA;
	
	/**
	 * 
	 */
	public int msideB;
	
	/**
	 * 
	 */
	public int msideC;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		
	}
	
	/**
	 * testretrieveTriangleTypeValid
	 * @throws Exception
	 */
	@Test
	public void testretrieveTriangleTypeValid() throws Exception{
		int sideA=1;
		int sideB=1;
		int sideC=1;
		when(triangleService.retrieveTriangleType(sideA, sideB, sideC)).thenReturn("Equilateral");
		triangleController.retrieveTriangleType(sideA, sideB, sideC, response);
		assertNotNull(triangleController.retrieveTriangleType(sideA, sideB, sideC, response));
		assertEquals("Service Result", "Equilateral", triangleService.retrieveTriangleType(sideA, sideB, sideC));
	}
	
	/**
	 * testretrieveTriangleTypeGenericInput
	 * @throws Exception
	 */
	@Test
	public void testretrieveTriangleTypeGenericInput() throws Exception{
		when(triangleService.retrieveTriangleType(msideA, msideB, msideC)).thenReturn(new String());
		triangleController.retrieveTriangleType(msideA, msideB, msideC, response);
		assertNotNull(triangleController.retrieveTriangleType(msideA, msideB, msideC, response));
	}
	
	/**
	 * testretrieveTriangleTypeFailure
	 * @throws Exception
	 */
	@Test(expected=NullPointerException.class)
	public void testretrieveTriangleTypeFailure() throws Exception{
		triangleController = new TriangleController();
		when(triangleService.retrieveTriangleType(msideA, msideB, msideC)).thenReturn(new String());
		triangleController.retrieveTriangleType(msideA, msideB, msideC, response);
	}

}
