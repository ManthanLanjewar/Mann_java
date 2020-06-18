package com.exception;

public class InvalidUsername extends Exception{
	String Msg;
	public InvalidUsername(String Msg)
	{
		this.Msg=Msg;
	}
	public String toString()
	{
		return "Exception is :"+Msg;
	}
}
