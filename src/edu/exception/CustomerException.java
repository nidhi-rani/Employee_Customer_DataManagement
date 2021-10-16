package edu.exception;

public class CustomerException extends Exception{
	public CustomerException() {
		super("Customer Error!");
	}
	public CustomerException(String msg) {
		super(msg);
	}

}
