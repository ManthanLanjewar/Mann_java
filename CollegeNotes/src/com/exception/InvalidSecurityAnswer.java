package com.exception;

public class InvalidSecurityAnswer extends Exception{
	String Msg;
	public InvalidSecurityAnswer(String Msg)
	{
		this.Msg=Msg;
	}
	public String toString()
	{
		return "Exception is :"+Msg;
	}

}
