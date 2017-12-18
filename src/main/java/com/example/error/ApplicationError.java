package com.example.error;

/**
 * This Error is thrown when code has encountered any situation which can not be handled and program can not continue to
 * complete user request. These situations are due to gaps and issues in the program logic.
 * @author gokulakannanv
 *
 */
public class ApplicationError extends AbstractError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Error messages. */	

	/**
	 * Instantiates a new application error.
	 *
	 * @param message the message
	 */
	public ApplicationError(final ExceptionErrorMessage ...errorMessages) {
		super(errorMessages);
	}
	
}
