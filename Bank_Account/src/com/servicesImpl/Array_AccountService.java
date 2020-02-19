package com.servicesImpl;

import com.services.AccountServicesSummary;
import com.bean.Account;
import com.exception.*;

//Java class of Implementation of Services provided by Interface class
public class Array_AccountService implements AccountServicesSummary
{
	private Account acc[]=new Account[2];
	private	int i=0;
	
	//Creating account and inserting data into database
	public int openAccount(String aType, float amount)
	{
		acc[i] =new Account(aType, amount);
		int ab=acc[i].getNo();
		i++;
		return ab;
	}
	//Method deposit for adding amount into account
	public float deposit(int aNo, float amount)throws InvalidAccountNoException
	{
		if(acc[0].getNo()==aNo)
		{
			float bal=acc[0].getAmount();
			bal=bal+amount;
			acc[0].setAmount(bal);
			return bal;
		}
		else if(acc[1].getNo()==aNo)
		{
			float bal=acc[1].getAmount();
			bal=bal+amount;
			acc[1].setAmount(bal);
			return bal;
		}
		else
		{
			throw new InvalidAccountNoException("Invalid Account Number ");
		}
	}
	//Method Withdraw for Withdrawing amount from account
	public float withdraw(int aNo, float amount) throws InsufficientAmountException, InvalidAccountNoException
	{
		float bal=acc[0].getAmount();
		if(acc[0].getNo() == aNo)
		{
			if(amount<bal)
			{
				bal=bal-amount;
				acc[0].setAmount(bal);
				System.out.println("Withdrawal amount 						:"+amount);
				return bal;
			}
			else
				throw new InsufficientAmountException("Insufficient balance to withdraw from your account ");
		
		}
		else
			throw new InvalidAccountNoException("Invalid Account Number ");
		
	}
	//Method accountDetails for fetching account Details from account
	public String accountDetails(int aNo)throws InvalidAccountNoException
	{
		if(acc[0].getNo()==aNo)
		{
			System.out.println(acc[0]);
			return null;
		}
		else if(acc[1].getNo()==aNo)
		{
			System.out.println(acc[1]);
			return null;
		}
		else
		{
			throw new InvalidAccountNoException("Invalid Account Number ");
		}
	}
	//Method balanceEnquiry to know the balance of account
	public float balanceEnquiry(int aNo)throws InvalidAccountNoException
	{
		if(acc[0].getNo()==aNo)
		{
			return acc[0].getAmount();
		}
		else if(acc[1].getNo()==aNo)
		{
			return acc[1].getAmount();
		}
		else
		{
			throw new InvalidAccountNoException("Invalid Account Number ");
		}
	}
	//Method fundTransfer for transfer of amount from one account to accNother account
	public void fundTransfer(int aNo1, int aNo2, float amount) throws InvalidAccountNoException, InsufficientAmountException
	{
		if((acc[0].getNo()==aNo1) && (acc[1].getNo()==aNo2))
		{    
			
			System.out.println("Balance after Funds transfer as follows:");
			System.out.println ("New balance in first account					:"+withdraw(aNo1, amount));
			
			System.out.println("New balance in second account					:"+deposit(aNo2, amount));
			
		}
		else
		{
			throw new InvalidAccountNoException("Invalid Account Number ");

		}
	}
}
