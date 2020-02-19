package com.servicesImpl;
import java.time.LocalDateTime;

import com.bean.User;
import com.exception.InvalidPassword;
import com.exception.InvalidSecurityAnswer;
import com.exception.InvalidUsername;
import com.services.UserServicesSummary;
import com.servicesImpl.UserServices;

public class UserServices implements UserServicesSummary
{
	static int num;
	private User u;
	static String tempPassword;
	//static variables
	//static int count=0;
	static int i=0;
	static String date[]= new String[6]; 
	static String event[] = new String[6];
	static{
		num=100;
		tempPassword="Abc@"+num;
	} 

	//logic for sign up
	public void signUp(String username, String pass, String sQue, String sAns )
	{
		u=new User(username, pass, sQue, sAns);
		System.out.println("Account Created Successfully with username: "+ u.getUsername());
		logCount("SignUp");
	}
	//for checking valid name and password of users
	public boolean checkUser(String username)
	{
		if(username == u.getUsername()) 
			return true;
		else
			return false;
	}
	public boolean checkPass(String pass)
	{
		if(pass == u.getPass())
			return true;
		else
			return false;
	}
	//logic for sign in	
	public boolean signIn(String username, String pass) throws InvalidUsername, InvalidPassword
	{
		if(checkUser(username))  
		{
			if(checkPass(pass))
			{
				System.out.println("Successfully logged in to your account. Welcome! "+u.getUsername());
				logCount("SignIn");
				return true;	
			}
			else
				throw new InvalidPassword("Invalid Password");
		}
		else
			throw new InvalidUsername("Invalid Username");
	}
	//logic for forget password
	public String forgetPassword(String username, String sAns) throws InvalidUsername, InvalidSecurityAnswer
	{
		logCount("Forget Password");
		if(checkUser(username)==true)
		{
			if(sAns == u.getsecurityAns())
			{
				num++;
				System.out.println("Username found.\nTemporary password sents.");
				return tempPassword;
			}
			else
				throw new InvalidSecurityAnswer("Invalid Security Answer");
		}
		else
		{
			throw new InvalidUsername("Invalid Username");	
		}
	}
	//logic to change forget password
	public void changeForgetPassword(String username, String tempPass, String newPass)
	{
		if(tempPass == tempPassword)
		{
			u.setPass(newPass);
			System.out.println("New Security Password set successfully for your account.");
		}
		logCount("Changing Forget Password");
	}
	//logic to change password
	public void changePassword(String username,String oldPass, String newPass) throws InvalidUsername,InvalidPassword
	{
		logCount("Change of password");
		if(checkUser(username)==true && oldPass==u.getPass())
		{
			if(checkPass(oldPass))
			{
				u.setPass(newPass);
				System.out.println("New Password set successfully for your account.");
			}
			else
				throw new InvalidPassword("Invalid Password");
		}
		else
			throw new InvalidUsername("Invalid username");
		
	}
	//logic for user activity
	
	public void getLogg(String username, String pass)
	{
		System.out.println("\nActivity by the user.");
		if(checkUser(username) && checkPass(pass))  
		{ 
			System.out.println("Successfully logged in to your account. Welcome! "+u.getUsername());
			//Logic for log services
			for(int m=0;m<i;m++)
				System.out.println(event[m]+"   "+date[m]);
		}
		else
		{
			//System.out.println("logged in to your account. Welcome! "+u.getUsername());

			if(pass==u.getPass())
				System.out.println("Can't show you because of Invalid username");
			else
				System.out.println("Can't show you because of Invalid username and password");
		}
	}
	
	public void logCount(String event)
	{
		LocalDateTime idt = LocalDateTime.now();
		date[i]	= idt.toString();
		UserServices.event[i] = event;
		i++;
	}
}







