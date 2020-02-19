package com.exception;

//Exception class for Invalid Account Number
public class InvalidAccountNoException extends Exception {
	String Msg;
	public InvalidAccountNoException(String Msg)
	{
		this.Msg=Msg;
	}
	public String toString()
	{
		return "Exception is :"+Msg;
	}
}


