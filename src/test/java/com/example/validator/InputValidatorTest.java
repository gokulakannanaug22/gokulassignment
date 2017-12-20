package com.example.validator;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;

import com.example.error.ApplicationError;
import com.example.error.InputError;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class) 
public class InputValidatorTest {
	
	/**
	 * inputValidator
	 */
	@InjectMocks
	public InputValidator inputValidator;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
	}
	
	/**
	 * testValidate
	 * @throws Exception
	 */
	@Test
	public void testValidateSuccess() throws Exception{
		boolean result = inputValidator.validate(10);
		assertTrue(result);
	}
	
	/**
	 * testValidate
	 * @throws Exception
	 */
	@Test(expected=InputError.class)
	public void testValidateInputError() throws Exception{
		inputValidator.validate(111111);
	}
	
	/**
	 * testValidate
	 * @throws Exception
	 */
	@Test(expected=ApplicationError.class)
	public void testValidateApplicationError() throws Exception{
		inputValidator.validate(-1);
	}
	
	/**
	 * testValidateTriangleSuccess
	 * @throws Exception
	 */
	@Test
	public void testValidateTriangleSuccess() throws Exception{
		boolean result = inputValidator.validate(1,1,1);
		assertTrue(result);
	}

	/**
	 * testValidateTriangleSuccess
	 * @throws Exception
	 */
	@Test(expected=InputError.class)
	public void testValidateTriangleInputError() throws Exception{
		boolean result = inputValidator.validate(-1,1,1);
		assertTrue(result);
	}
	
	/**
	 * testCheckNonNegative
	 * @throws Exception
	 */
	@Test(expected=InputError.class)
	public void testCheckNonNegative() throws Exception{
		Whitebox.invokeMethod(inputValidator, "checkNonNegative", 0, -1, -2);
	}
}
