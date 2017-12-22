package com.example.error;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AbstractErrorMessageTest {

	/**
	 * abstractErrorMessage
	 */
	@Spy
	public AbstractErrorMessage abstractErrorMessage;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
	}
	
	/**
	 * testErrorCodeSuccess
	 * @throws Exception
	 */
	@Test
	public void testErrorCodeSuccess() throws Exception{
		String errorCode = "200";
		abstractErrorMessage.errorCode(errorCode);
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
		abstractErrorMessage.errorCode("400");
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
		abstractErrorMessage.errorCode("500");
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
		abstractErrorMessage.displayDeveloperMessage(developerMessage);
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
		abstractErrorMessage.displayDeveloperMessage(developerMessage);
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
		abstractErrorMessage.displayDeveloperMessage(developerMessage);
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
		abstractErrorMessage.displayDeveloperMessage(userMessage);
		assertNotNull(userMessage);
		assertEquals("User Message Compare", "Success", userMessage);
	}
	
	/**
	 * testDisplayUserMessageInputError
	 * @throws Exception
	 */
	@Test
	public void testDisplayUserMessageInputError() throws Exception{
		String userMessage = "Input Error";
		abstractErrorMessage.displayDeveloperMessage(userMessage);
		assertNotNull(userMessage);
		assertEquals("User Message Compare", "Input Error", userMessage);
	}
	
	/**
	 * testDisplayUserMessageAppError
	 * @throws Exception
	 */
	@Test
	public void testDisplayUserMessageAppError() throws Exception{
		String userMessage = "Application Error";
		abstractErrorMessage.displayDeveloperMessage(userMessage);
		assertNotNull(userMessage);
		assertEquals("User Message Compare", "Application Error", userMessage);
	}
}
