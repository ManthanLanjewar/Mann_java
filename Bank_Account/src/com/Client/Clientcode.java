package com.Client;

import com.services.AccountServicesSummary;
import com.exception.InsufficientAmountException;
import com.exception.InvalidAccountNoException;
import com.providers.AccountServiceProvider;


//Java class for client access for input.
public class Clientcode {

	public static void main(String[] args)
	{	
		AccountServicesSummary a = AccountServiceProvider.createObjectAcc();
		
		//openAccount for new account
		System.out.println("Account number is  					:"+a.openAccount("Saving", 10000.0f));
		System.out.println("Next account number is 				:"+a.openAccount("Current", 15000.0f));
		
		//method for depositing Amount in Account
		try
		{
			System.out.println("Balance after Amount deposited in account 		:"+a.deposit(1, 1000.0f));
		}
		catch(InvalidAccountNoException e)
		{
			e.printStackTrace();
		}

		//method for withdrawal of Amount from Account
		try
		{
			System.out.println("Amount remaining in account 				:" +a.withdraw(1, 5000.0f));
		}
		catch(InsufficientAmountException e)
		{
			e.printStackTrace();
		}
		catch(InvalidAccountNoException e)
		{
			e.printStackTrace();
		}
		
		
		//method for fetching details of Account from account number
		try
		{
			System.out.println("Your account details are as follows:");
			a.accountDetails(1);
		}
		catch(InvalidAccountNoException e)
		{
			e.printStackTrace();
		}
		
		//Method for fund transfer of Amount from two Accounts
		try {
			a.fundTransfer(1, 2, 1000.0f);
		} catch (InsufficientAmountException | InvalidAccountNoException e) {
			e.printStackTrace();
		}
	
	}
}//End of class
