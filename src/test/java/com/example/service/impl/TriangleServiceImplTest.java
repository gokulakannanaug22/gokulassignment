package com.example.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.example.validator.InputValidator;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TriangleServiceImplTest {

	/**
	 * triangleService
	 */
	@InjectMocks
	public TriangleServiceImpl triangleService;
	
	/**
	 * mInputValidator
	 */
	@Mock
	public InputValidator mInputValidator;

	/**
	 * setUp
	 */
	@Before
	public void setUp(){
	}
	
	/**
	 * testretrieveTriangleTypeEquivalateral
	 * @throws Exception
	 */
	@Test
	public void testretrieveTriangleTypeEquivalateral() throws Exception{
		int sideA=1;
		int sideB=1;
		int sideC=1;
		when(mInputValidator.validate(sideA, sideB, sideC)).thenReturn(true);	
		triangleService.retrieveTriangleType(sideA, sideB, sideC);
		assertNotNull(triangleService.retrieveTriangleType(sideA, sideB, sideC));
		assertEquals("Triangle Type", "Equilateral", triangleService.retrieveTriangleType(sideA, sideB, sideC));
	}
	
	/**
	 * testretrieveTriangleTypeIsocelesError
	 * @throws Exception
	 */
	@Test(expected=java.lang.AssertionError.class)
	public void testretrieveTriangleTypeIsocelesError() throws Exception{
		int sideA=1;
		int sideB=2;
		int sideC=1;
		triangleService.retrieveTriangleType(sideA, sideB, sideC);
		assertNotNull(triangleService.retrieveTriangleType(sideA, sideB, sideC));
		assertEquals("Triangle Type", "Isosceles", triangleService.retrieveTriangleType(sideA, sideB, sideC));
	}
	
	/**
	 * testretrieveTriangleTypeIsoceles
	 * @throws Exception
	 */
	@Test
	public void testretrieveTriangleTypeIsoceles() throws Exception{
		int sideA=1;
		int sideB=2;
		int sideC=1;
		when(mInputValidator.validate(sideA, sideB, sideC)).thenReturn(true);	
		triangleService.retrieveTriangleType(sideA, sideB, sideC);
		assertNotNull(triangleService.retrieveTriangleType(sideA, sideB, sideC));
		assertEquals("Triangle Type", "Isosceles", triangleService.retrieveTriangleType(sideA, sideB, sideC));
	}
	
	/**
	 * testretrieveTriangleTypeScalene
	 * @throws Exception
	 */
	@Test
	public void testretrieveTriangleTypeScalene() throws Exception{
		int sideA=6;
		int sideB=2;
		int sideC=3;
		when(mInputValidator.validate(sideA, sideB, sideC)).thenReturn(true);	
		triangleService.retrieveTriangleType(sideA, sideB, sideC);
		assertNotNull(triangleService.retrieveTriangleType(sideA, sideB, sideC));
		assertEquals("Triangle Type", "Scalene", triangleService.retrieveTriangleType(sideA, sideB, sideC));
	}
	
	/**
	 * testtriangleTypeEquivalateral
	 * @throws Exception
	 */
	@Test
	public void testtriangleTypeEquivalateral() throws Exception{
		int sideA=1;
		int sideB=1;
		int sideC=1;
		triangleService.triangleType(sideA, sideB, sideC);
		assertEquals("Triangle Type", "Equilateral", triangleService.triangleType(sideA, sideB, sideC));
		assertNotNull(triangleService.triangleType(sideA, sideB, sideC));
		assertEquals("Triangle Type", "Equilateral", triangleService.triangleType(sideA, sideB, sideC));
	}
	
	/**
	 * testtriangleTypeScalene
	 * @throws Exception
	 */
	@Test
	public void testtriangleTypeScalene() throws Exception{
		int sideA=1;
		int sideB=2;
		int sideC=3;
		triangleService.triangleType(sideA, sideB, sideC);
		assertEquals("Triangle Type", "Scalene", triangleService.triangleType(sideA, sideB, sideC));
		assertNotNull(triangleService.triangleType(sideA, sideB, sideC));
		assertEquals("Triangle Type", "Scalene", triangleService.triangleType(sideA, sideB, sideC));
	}
	
	/**
	 * testtriangleTypeIsosceles
	 * @throws Exception
	 */
	@Test
	public void testtriangleTypeIsosceles() throws Exception{
		int sideA=1;
		int sideB=2;
		int sideC=1;
		triangleService.triangleType(sideA, sideB, sideC);
		assertEquals("Triangle Type", "Isosceles", triangleService.triangleType(sideA, sideB, sideC));
		assertNotNull(triangleService.triangleType(sideA, sideB, sideC));
		assertEquals("Triangle Type", "Isosceles", triangleService.triangleType(sideA, sideB, sideC));
	}
	
}
