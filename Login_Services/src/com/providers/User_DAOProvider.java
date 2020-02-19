package com.providers;


import com.daoserviceimpl.UserDAOServiceImpl;
import com.daoservices.UserDAOServicesSummary;


//Java Class for Object provider of DAO class to the Implementation class
public class User_DAOProvider 
{
 public static UserDAOServicesSummary getDaoObject()
 {
	 UserDAOServicesSummary dao = null;
	 dao = new UserDAOServiceImpl();
	 return dao;
 }
}
