package com.Client;

import com.exception.InvalidPassword;
import com.exception.InvalidSecurityAnswer;
import com.exception.InvalidUsername;
import com.providers.UserServiceProvider;
import com.services.UserServicesSummary;
import com.Client.UserActivity;

public class UserActivity 
{
	public static void main(String[] args) 
	{
		UserServicesSummary u= UserServiceProvider.createObjectUser();
		
		u.signUp("Manthan", "M@123", "Fav Game", "Volleyball");
		//
		try {
			u.signIn("Manthan", "M@123");
		}
		catch (InvalidUsername e)
		{
			e.printStackTrace();
		} 
		catch (InvalidPassword e)
		{
			e.printStackTrace();
		} 
		
		//
		String tempP;
		try 
		{
			tempP = u.forgetPassword("Manthan", "Volleyball");
			u.changeForgetPassword("Manthan", tempP, "Mann@10");
		} 
		catch (InvalidUsername e) 
		{
			e.printStackTrace();
		}
		catch (InvalidSecurityAnswer e)
		{
			e.printStackTrace();
		}
		
		//
		try
		{
			u.changePassword("Manthan", "Mann@10","Mann@99");
		} 
		catch (InvalidUsername e) 
		{
			e.printStackTrace();
		} 
		catch (InvalidPassword e)
		{
			e.printStackTrace();
		}
		try {
			u.getLogg("Manthan","Mann@99");
		}
		catch (InvalidUsername e) 
		{
			e.printStackTrace();
		} 
		catch (InvalidPassword e) 
		{	
			e.printStackTrace();
		}
	}
}
