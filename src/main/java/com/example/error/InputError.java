package com.example.error;

/**
 * @author gokulakannanv
 *
 */
public class InputError extends AbstractError {
	
	/**
	 * serial version uid.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new input error.
	 *
	 * @param message the message
	 */
	public InputError(final ExceptionErrorMessage ...errorMessages) {
		super(errorMessages);
	}

}