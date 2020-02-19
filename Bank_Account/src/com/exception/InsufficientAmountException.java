package com.exception;

//Exception class for Insufficient Amount in account
public class InsufficientAmountException extends Exception {
	String Msg;
	public InsufficientAmountException(String Msg)
	{
		this.Msg=Msg;
	}
	public String toString()
	{
		return "Exception is :"+Msg;
	}
}
