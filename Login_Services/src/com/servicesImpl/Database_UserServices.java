package com.servicesImpl;
import java.time.LocalDateTime;

import com.bean.User;
import com.daoservices.UserDAOServicesSummary;
import com.exception.InvalidPassword;
import com.exception.InvalidSecurityAnswer;
import com.exception.InvalidUsername;
import com.providers.User_DAOProvider;
import com.services.UserServicesSummary;
import com.servicesImpl.Database_UserServices;

public class Database_UserServices implements UserServicesSummary
{
	static int i=0;
	static String date[]= new String[6]; 
	static String event[] = new String[6];
	
	private User user= null;
	UserDAOServicesSummary dao= User_DAOProvider.getDaoObject();

	//logic for sign up
	public void signUp(String username, String pass, String sQue, String sAns )
	{
		user=new User(username, pass, sQue, sAns);
		int count = dao.insertUserData(user);
		if(count != 0)
			System.out.println("Account Created Successfully with username: "+ user.getUsername());
		logCount("SignUp");
	}
	
	//logic for sign in	
	public boolean signIn(String username, String pass) throws InvalidUsername, InvalidPassword
	{
		user = dao.checkUsername(username);
		if(user!=null)  
		{
			if(pass.equals(user.getPass()))
			{
				System.out.println("Successfully logged in to your account. Welcome! "+user.getUsername());
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
	public String forgetPassword(String username, String securityAns) throws InvalidUsername, InvalidSecurityAnswer
	{
		user = dao.checkUsername(username);
		if(user!=null)  
		{
			
			if(securityAns.equals(user.getsecurityAns()))
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
	static int num;
	static String tempPassword;
	static{
		num=100;
		tempPassword="Abc@"+num;
	} 
	public void changeForgetPassword(String username, String tempPass, String newPass)
	{
		if(tempPass == tempPassword)
		{
			user.setPass(newPass);
			dao.changePassword(username, newPass);
			System.out.println("New Password set successfully for your account.");
		}
		logCount("Changing Forget Password");
	}
	//logic to change password
	public void changePassword(String username,String oldPass, String newPass) throws InvalidUsername,InvalidPassword
	{
		logCount("Change of password");
		
		user = dao.checkUsername(username);
		if(user!=null)  
		{
			if(oldPass.equals(user.getPass()))
			{
				user.setPass(newPass);
				dao.changePassword(username, newPass);
				System.out.println("New Password set successfully for your account.");
			}
			else
				throw new InvalidPassword("Invalid Password");
		}
		else
			throw new InvalidUsername("Invalid username");
		
	}
	//logic for user activity
	
	public void getLogg(String username, String pass) throws InvalidUsername,InvalidPassword
	{
		System.out.println("\nActivity by the user.");
		user = dao.checkUsername(username);
		if(user !=null)  
		{ 
			if(pass.equals(user.getPass()))
			{
				System.out.println("Successfully logged in to your account. Welcome! "+user.getUsername());
				//Logic for log services
				for(int m=0;m<i;m++)
					System.out.println(event[m]+"   "+date[m]);
			}
			else
				throw new InvalidPassword("Invalid Password");
		}
		else
			throw new InvalidUsername("Invalid Username");
	}
	
	public void logCount(String event)
	{
		LocalDateTime idt = LocalDateTime.now();
		date[i]	= idt.toString();
		Database_UserServices.event[i] = event;
		i++;
	}
}







