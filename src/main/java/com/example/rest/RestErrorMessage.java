package com.example.rest;

import com.example.error.AbstractErrorMessage;

/**
 * This class is used to send the error message in the REST response and used by RestResponse class.
 * 
 * @author gokulakannanv
 *
 */
public final class RestErrorMessage extends AbstractErrorMessage {


	/**
	 * Instantiates a new error message.
	 */
	public RestErrorMessage() {
		super();
	}

	/**
	 * Create new error message.
	 * 
	 * @return Empty ErrorMessage object
	 */
	public static RestErrorMessage newObject() {
		return new RestErrorMessage();
	}

	/**
	 * Set error code. All errors may not have error code but error messages
	 * which contains user message must have code.
	 *
	 * @param code
	 *            the code
	 * @return the error message
	 */
	@Override
	public RestErrorMessage errorCode(final String code) {
		this.code = code;
		return this;
	}
	
	/**
	 * Error message to be shown to user/customer.
	 *
	 * @param userMessage
	 *            the user message
	 * @return the error message
	 */
	@Override
	public RestErrorMessage displayUserMessage(final String userMessage) {
		this.userMessage = userMessage;
		return this;
	}

	/**
	 * Detail error message which developer can use to debug the application
	 * issues.
	 *
	 * @param developerMessage
	 *            the developer message
	 * @return the error message
	 */
	@Override
	public RestErrorMessage displayDeveloperMessage(final String developerMessage) {
		this.developerMessage = developerMessage;
		return this;
	}
	
	/**
	 * (non-Javadoc).
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExceptionErrorMessage [code=" + code + ", userMessage=" + userMessage + ", developerMessage=" + developerMessage + "]";
	}

}
