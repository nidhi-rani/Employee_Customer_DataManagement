package edu.exception;

public class EmployeeException extends Exception{
	public EmployeeException() {
		super("Employee Error!");
	}
	public EmployeeException(String msg) {
		super(msg);
	}
}
