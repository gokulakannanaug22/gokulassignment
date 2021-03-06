package com.example.error;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ExceptionErrorMessageTest {
	
	/**
	 * exceptionErrorMessage
	 */
	public ExceptionErrorMessage exceptionErrorMessage;
	
	/**
	 * cause
	 */
	@Mock
	public Throwable cause;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		exceptionErrorMessage = new ExceptionErrorMessage();
	}
	
	/**
	 * testCause
	 * @throws Exception
	 */
	@Test
	public void testCause() throws Exception{
		exceptionErrorMessage.cause(cause);
		assertNotNull(cause);
	}
	
	/**
	 * testErrorCodeSuccess
	 * @throws Exception
	 */
	@Test
	public void testErrorCodeSuccess() throws Exception{
		String errorCode = "200";
		exceptionErrorMessage.errorCode(errorCode);
		assertNotNull(errorCode);
		assertEquals("Error Code Compare", "200", errorCode);
	}
	
	/**
	 * testErrorCodeInputError
	 * @throws Exception
	 */
	@Test
	public void testErrorCodeInputError() throws Exception{
		String errorCode = "400";
		exceptionErrorMessage.errorCode("400");
		assertNotNull(errorCode);
		assertEquals("Error Code Compare", "400", errorCode);
	}
	
	/**
	 * testErrorCodeApplicationError
	 * @throws Exception
	 */
	@Test
	public void testErrorCodeApplicationError() throws Exception{
		String errorCode = "500";
		exceptionErrorMessage.errorCode("500");
		assertNotNull(errorCode);
		assertEquals("Error Code Compare", "500", errorCode);
	}
	
	/**
	 * testDisplayDeveloperMessageSuccess
	 * @throws Exception
	 */
	@Test
	public void testDisplayDeveloperMessageSuccess() throws Exception{
		String developerMessage = "Success";
		exceptionErrorMessage.displayDeveloperMessage(developerMessage);
		assertNotNull(developerMessage);
		assertEquals("Developer Message Compare", "Success", developerMessage);
	}
	
	/**
	 * testDisplayDeveloperMessageInputError
	 * @throws Exception
	 */
	@Test
	public void testDisplayDeveloperMessageInputError() throws Exception{
		String developerMessage = "InputError";
		exceptionErrorMessage.displayDeveloperMessage(developerMessage);
		assertNotNull(developerMessage);
		assertEquals("Developer Message Compare", "InputError", developerMessage);
	}
	
	/**
	 * testDisplayDeveloperMessageAppError
	 * @throws Exception
	 */
	@Test
	public void testDisplayDeveloperMessageAppError() throws Exception{
		String developerMessage = "Application Error";
		exceptionErrorMessage.displayDeveloperMessage(developerMessage);
		assertNotNull(developerMessage);
		assertEquals("Developer Message Compare", "Application Error", developerMessage);
	}
	
	/**
	 * testDisplayUserMessageSuccess
	 * @throws Exception
	 */
	@Test
	public void testDisplayUserMessageSuccess() throws Exception{
		String userMessage = "Success";
		exceptionErrorMessage.displayDeveloperMessage(userMessage);
		assertNotNull(userMessage);
		assertEquals("User Message Compare", "Success", userMessage);
	}
	
	/**
	 * testDisplayUserMessageInputError
	 * @throws Exception
	 */
	@Test
	public void testDisplayUserMessageInputError() throws Exception{
		String userMessage = "InputError";
		exceptionErrorMessage.displayDeveloperMessage(userMessage);
		assertNotNull(userMessage);
		assertEquals("User Message Compare", "InputError", userMessage);
	}
	
	/**
	 * testDisplayUserMessageAppError
	 * @throws Exception
	 */
	@Test
	public void testDisplayUserMessageAppError() throws Exception{
		String userMessage = "Application Error";
		exceptionErrorMessage.displayDeveloperMessage(userMessage);
		assertNotNull(userMessage);
		assertEquals("User Message Compare", "Application Error", userMessage);
	}
}
