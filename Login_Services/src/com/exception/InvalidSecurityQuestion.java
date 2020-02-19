package com.exception;

public class InvalidSecurityQuestion extends Exception{
	String Msg;
	public InvalidSecurityQuestion(String Msg)
	{
		this.Msg=Msg;
	}
	public String toString()
	{
		return "Exception is :"+Msg;
	}

}
