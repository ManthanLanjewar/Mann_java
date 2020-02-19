package com.daoservices;

import com.bean.Account;

//AccountDAOServicesSummary provides interface services

public interface AccountDAOServicesSummary 
{
	int insertAccountData(Account acc);
	Account checkValidAccountNumber(int accNo);
	int getAccountNumber();
	int depositAmount(int accNo, float amount);
	int withdrawAmount(int accNo, float amount);
	public Account getAccountDetails(int accNo); 
}
