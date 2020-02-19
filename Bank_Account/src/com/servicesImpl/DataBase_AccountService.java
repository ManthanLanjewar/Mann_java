package com.servicesImpl;

import com.providers.Account_DAOProvider;
import com.services.AccountServicesSummary;
import com.bean.Account;
import com.daoservices.AccountDAOServicesSummary;
import com.exception.*;

//Java class of Implementation of Services provided by Interface class
public class DataBase_AccountService implements AccountServicesSummary
{
	private Account acc= null;
	AccountDAOServicesSummary dao= Account_DAOProvider.getDaoObject();
	
	//Creating account and inserting data into database
	public int openAccount(String aType, float amount)
	{
		acc =new Account(aType, amount);
		int count = dao.insertAccountData(acc);
		if(count>0)
		{
			System.out.println("Account Created successfully ");
		}
		int accountNumber = dao.getAccountNumber();
		return accountNumber;
	}
	
	//Method deposit for adding amount into account
	public float deposit(int accNo, float amount)throws InvalidAccountNoException
	{
		acc = dao.checkValidAccountNumber(accNo);
		if(acc != null)
		{
			int updateCount = dao.depositAmount(accNo, amount);
			if(updateCount>0)
				System.out.println("Amount deposit successfully");
			acc = dao.getAccountDetails(accNo);	//for getting updated account details
			return acc.getAmount();   //return the current balance
		}
		else
			throw new InvalidAccountNoException("Invalid Account Number ");
	}
	//Method Withdraw for Withdrawing amount from account
	public float withdraw(int accNo, float amount) throws InsufficientAmountException, InvalidAccountNoException
	{
		acc = dao.checkValidAccountNumber(accNo);
		if(acc != null)
		{
			int updateCount = dao.withdrawAmount(accNo, amount);
			if(updateCount>0)
			{
				System.out.println("Amount withdraw successfully");
				acc = dao.getAccountDetails(accNo);		//for getting updated account details
				return acc.getAmount();	 //return the current balance
			}
			else 
				throw new InsufficientAmountException("Insufficient balance to withdraw from your account ");
		}
		else
			throw new InvalidAccountNoException("Account not found so cannot fetch Account details");
	}	
	
	//Method accountDetails for fetching account Details from account
	public String accountDetails(int accNo)throws InvalidAccountNoException
	{
		acc = dao.checkValidAccountNumber(accNo);
		if(acc != null)
		{
			System.out.println("	Account Number 		:"+accNo+acc);
			return "Account details Feteched";
		}
		else
			throw new InvalidAccountNoException("Invalid Account Number ");
	}
	
	//Method balanceEnquiry to know the balance of account
	public float balanceEnquiry(int accNo)throws InvalidAccountNoException
	{
		acc = dao.checkValidAccountNumber(accNo);
		if(acc != null)
			return acc.getAmount();
		
		else
			throw new InvalidAccountNoException("Invalid Account Number ");
	}

	//Method fundTransfer for transfer of amount from one account to accNother account
	public void fundTransfer(int accNo1, int accNo2, float amount) throws InvalidAccountNoException, InsufficientAmountException
	{
		Account acc2 = null;
		acc = dao.checkValidAccountNumber(accNo1);
		acc2 = dao.checkValidAccountNumber(accNo2);
		if(acc != null)
		{    
			if(acc2 != null)
			{	
				System.out.println("Balance after Funds transfer as follows:");
				System.out.println ("New balance in first account					:"+withdraw(accNo1, amount));
				System.out.println("New balance in second account					:"+deposit(accNo2, amount));
			}
			else
				throw new InvalidAccountNoException("Invalid Account Number "+accNo2);
		}
		else
			throw new InvalidAccountNoException("Invalid Account Number "+accNo1);
	}
}
