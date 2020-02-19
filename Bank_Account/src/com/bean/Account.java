package com.bean;

public class Account 
{
	//instance Variables for holding account Data
	private int accNo;
	private String aType;
	private float amount;
	//static int ser=1000;  //for implementation of classes Array and ArrayList
	
	//Parameterize constructor
	public Account(String aType, float amount)
	{
		//this.accNo=ser;
		//ser++;
		this.aType=aType;
		this.amount=amount;
	}
	//Getter And Setter method
	public void setNo(int accNo)
	{
		this.accNo=accNo;
	}
	public void setType(String aType)
	{
		this.aType=aType;
	}
	public void setAmount(float amount)
	{
		this.amount=amount;
	}
	
	public int getNo()
	{
		return accNo;
	}
	public String getType()
	{
		return aType;
	}
	public float getAmount()
	{
		return amount;
	}
	//toString method
	public String toString()
	{
		return "\n	Account type 		:"+aType+"\n	Account balance 	:"+amount;
		//Use the below return statement for Array_AccountService and ArrayList_AccountService classes implementation
		//return "	Account number 		:"+accNo+"\n	Account type 		:"+aType+"\n	Account balance 	:"+amount;
	}

}//End of class