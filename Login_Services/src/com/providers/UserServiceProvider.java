package com.providers;

import com.services.UserServicesSummary;
import com.servicesImpl.Database_UserServices;


public class UserServiceProvider {
	public static UserServicesSummary createObjectUser(){
		return new Database_UserServices();
	}
}
