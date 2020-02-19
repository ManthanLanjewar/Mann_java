package com.providers;


import com.daoserviceimpl.AccountDAOServiceImpl;
import com.daoservices.AccountDAOServicesSummary;


//Java Class for Object provider of DAO class to the Implementation class
public class DAOProvider 
{
 public static AccountDAOServicesSummary getDaoObject()
 {
	 AccountDAOServicesSummary dao = null;
	 dao = new AccountDAOServiceImpl();
	 return dao;
 }
}
