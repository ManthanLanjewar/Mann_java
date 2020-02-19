package com.bean;

public class User 
{
	//Declaration of instance variable
	private String username ;
	private String pass;
	private String securityQue;
	private String securityAns;
	//creating parameterize constructor
	public User(String username,String pass,String securityQue,String securityAns)
	{
		this.username=username;
		this.pass=pass;
		this.securityQue=securityQue;
		this.securityAns=securityAns;
	}
	//creating setter method
	public void setUsername(String username)
	{
		this.username=username;
	}
	public void setPass(String pass)
	{
		this.pass=pass;
	}
	public void setsecurityQue(String securityQue)
	{
		this.securityQue=securityQue;
	}
	public void setsecurityAns(String securityAns)
	{
		this.securityAns=securityAns;
	}
	//creating getter method
	public String getUsername()
	{
		return username;
	}
	public String getPass()
	{
		return pass;
	}
	public String getsecurityQue()
	{
		return securityQue;
	}
	public String getsecurityAns()
	{
		return securityAns;
	}
	//creating toString method
	public String toString()
	{
		return "Username :"+username;
	}
	
}
