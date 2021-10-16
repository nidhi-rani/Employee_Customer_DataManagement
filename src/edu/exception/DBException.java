package edu.exception;

public class DBException extends Exception{
	public DBException() {
		super("Database Connection Error!");
	}
	public DBException(String msg) {
		super(msg);
	}

}
