package com.exception;

public class InvalidPassword extends Exception{
	String Msg;
	public InvalidPassword(String Msg)
	{
		this.Msg=Msg;
	}
	public String toString()
	{
		return "Exception is :"+Msg;
	}
}
