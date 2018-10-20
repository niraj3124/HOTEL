package com.capgemini.exception;
/*
 * User defined exception
 */

public class HotelBookingException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelBookingException(String message)
	{
		super(message);
	}

}
