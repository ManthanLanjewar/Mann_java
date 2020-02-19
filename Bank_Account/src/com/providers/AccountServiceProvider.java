package com.providers;


import com.servicesImpl.DataBase_AccountService;
import com.services.*;


//Java Class for object creation of Class by Provider to the Implementation Class
public class AccountServiceProvider {
	public static AccountServicesSummary createObjectAcc(){
		return new DataBase_AccountService();
	}
	
}
