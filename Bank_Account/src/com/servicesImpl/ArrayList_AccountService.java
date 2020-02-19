package com.servicesImpl;

import java.util.ArrayList;
import java.util.Iterator;
import com.services.AccountServicesSummary;
import com.bean.Account;
import com.exception.*;


//Java class of Implementation of Services provided by Interface class
public class ArrayList_AccountService implements AccountServicesSummary
{
	public ArrayList<Account> a= new ArrayList<>();
	public Account acc;
	
	//Creating account and inserting data into database
	public int openAccount(String aType, float amount)
	{
		acc =new Account(aType, amount);
		int ab=acc.getNo();
		a.add(acc);
		return ab;
	}
	//Method deposit for adding amount into account
	public float deposit(int aNo, float amount)throws InvalidAccountNoException
	{
		int m = checkNo(aNo);
		if( m != -1){
			acc = a.get(m);
			float bal = acc.getAmount();
			bal=bal+amount;
			acc.setAmount(bal);
			return bal;
		}
		else
			throw new InvalidAccountNoException("Invalid Account Number ");	
	}
	//Method Withdraw for Withdrawing amount from account
	public float withdraw(int aNo, float amount) throws InsufficientAmountException, InvalidAccountNoException
	{
		int m = checkNo(aNo);
		if( m != -1)
		{
			acc = a.get(m);
			float bal=acc.getAmount();
			if(bal >= amount)
			{
				bal=bal-amount;
				acc.setAmount(bal);
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
		int m = checkNo(aNo);
		if(m != -1){
			acc = a.get(m);
			System.out.println(acc);
			return null;
		}
		else
			throw new InvalidAccountNoException("Invalid Account Number ");
	}
	//Method balanceEnquiry to know the balance of account
	public float balanceEnquiry(int aNo)throws InvalidAccountNoException
	{
		int m = checkNo(aNo);
		if(m != -1){
			acc = a.get(m);
			return acc.getAmount();
		}
		else
			throw new InvalidAccountNoException("Invalid Account Number ");
	}
	//Method fundTransfer for transfer of amount from one account to accNother account
	public void fundTransfer(int aNo1, int aNo2, float amount) throws InvalidAccountNoException, InsufficientAmountException
	{
		int m = checkNo(aNo1);
		int m2 = checkNo(aNo2);
		if(m != -1 && m2 != -1){    
			System.out.println("Balance after Funds transfer as follows:");
			System.out.println ("New balance in first account					:"+withdraw(aNo1, amount));
			System.out.println("New balance in second account					:"+deposit(aNo2, amount));	
		}
		else
			throw new InvalidAccountNoException("Invalid Account Number ");
	}
	//For Checking validity of account Number
	public int checkNo(int aNo)
	{
		Iterator<Account> ib = a.iterator();
		while(ib.hasNext()){
			Account acc = ib.next();
			if(acc.getNo() == aNo){
				return a.indexOf(acc);
			}
		}return -1;
	}
}






