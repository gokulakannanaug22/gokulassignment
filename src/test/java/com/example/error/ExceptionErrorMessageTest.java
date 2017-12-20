package com.example.error;

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
	
	@Test
	public void testCause() throws Exception{
		exceptionErrorMessage.cause(cause);
	}
}
