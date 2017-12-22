package com.example.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.error.ExceptionErrorMessage;
import com.example.error.InputError;
import com.example.rest.RestErrorMessage;
import com.example.rest.RestResponse;
import com.example.rest.ServiceExecutor;
import static org.mockito.Mockito.when;

/**
 * @author gokulakannanv
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RestResponseTest {

	/**
	 * RestResponse
	 */
	public RestResponse RestResponse;
	
	/**
	 * service
	 */
	@Mock
	public ServiceExecutor service;
	
	/**
	 * errors
	 */
	public ExceptionErrorMessage errors;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		errors = new ExceptionErrorMessage();
	}
	
	/**
	 * testbuild
	 * @throws Exception
	 */
	@Test
	public void testbuild() throws Exception{
		when(service.execute()).thenReturn(null);
		com.example.rest.RestResponse.build(service);
	}
	
	/**
	 * testbuildError
	 * @throws Exception
	 */
	@Test(expected=NullPointerException.class)
	public void testbuildError() throws Exception{
		ServiceExecutor serviceExec = null;
		com.example.rest.RestResponse.build(serviceExec);
	}
	
	/**
	 * testErrorMessageSuccess
	 * @throws Exception
	 */
	@Test
	public void testErrorMessageSuccess() throws Exception{
		RestResponse restResponse = new RestResponse();
		errors.errorCode("200");
		errors.displayUserMessage("Success");
		errors.displayDeveloperMessage("Success");
		Whitebox.invokeMethod(restResponse, "errorMessage", errors);
	}
	
	/**
	 * testErrorMessageInputError
	 * @throws Exception
	 */
	@Test
	public void testErrorMessageInputError() throws Exception{
		RestResponse restResponse = new RestResponse();
		errors.errorCode("400");
		errors.displayUserMessage("Input Error");
		errors.displayDeveloperMessage("Input Error");
		Whitebox.invokeMethod(restResponse, "errorMessage", errors);
	}
	
	/**
	 * testErrorMessageApplicationError
	 * @throws Exception
	 */
	@Test
	public void testErrorMessageApplicationError() throws Exception{
		RestResponse restResponse = new RestResponse();
		errors.errorCode("500");
		errors.displayUserMessage("Application Error");
		errors.displayDeveloperMessage("Application Error");
		Whitebox.invokeMethod(restResponse, "errorMessage", errors);
	}
	
	/**
	 * testErrorMessageParameterSuccess
	 * @throws Exception
	 */
	@Test
	public void testErrorMessageParameterSuccess() throws Exception{
		RestResponse restResponse = new RestResponse();
		RestErrorMessage errors = new RestErrorMessage();
		errors.errorCode("200");
		errors.displayUserMessage("Success");
		errors.displayDeveloperMessage("Success");
		Whitebox.invokeMethod(restResponse, "errorMessage", errors);
	}
	
	/**
	 * testErrorMessageParameterInputError
	 * @throws Exception
	 */
	@Test
	public void testErrorMessageParameterInputError() throws Exception{
		RestResponse restResponse = new RestResponse();
		RestErrorMessage errors = new RestErrorMessage();
		errors.errorCode("400");
		errors.displayUserMessage("Input Error");
		errors.displayDeveloperMessage("Input Error");
		Whitebox.invokeMethod(restResponse, "errorMessage", errors);
	}
	
	/**
	 * testErrorMessageParameterInputError
	 * @throws Exception
	 */
	@Test
	public void testErrorMessageParameterApplicationError() throws Exception{
		RestResponse restResponse = new RestResponse();
		RestErrorMessage errors = new RestErrorMessage();
		errors.errorCode("500");
		errors.displayUserMessage("Application Error");
		errors.displayDeveloperMessage("Application Error");
		Whitebox.invokeMethod(restResponse, "errorMessage", errors);
	}
}
