package com.services;

import com.exception.InvalidPassword;
import com.exception.InvalidSecurityAnswer;
import com.exception.InvalidUsername;

//Interface which provides abstract method for implementation

public interface UserServicesSummary {
	void signUp(String username, String pass, String sQue, String sAns );
	boolean signIn(String username, String pass) throws InvalidUsername, InvalidPassword;
	String forgetPassword(String username, String sAns) throws InvalidUsername, InvalidSecurityAnswer;
	void changeForgetPassword(String username, String tempPass, String newPass);
	void changePassword(String username,String oldPass, String newPass) throws InvalidUsername, InvalidPassword;
	void getLogg(String username, String pass) throws InvalidUsername, InvalidPassword; 
}
