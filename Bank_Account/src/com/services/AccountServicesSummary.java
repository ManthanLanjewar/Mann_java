package com.services;

import com.exception.*;

//Account Services Summary provides interface for account services.

public interface AccountServicesSummary {
	 int openAccount(String aType, float amount);
	 float deposit(int aNo, float amount) throws InvalidAccountNoException;
	 float withdraw(int aNo, float amount) throws InsufficientAmountException, InvalidAccountNoException;
	 String accountDetails(int aNo)throws InvalidAccountNoException;
	 float balanceEnquiry(int aNo) throws InvalidAccountNoException;
	 void fundTransfer(int aNo1, int aNo2, float amount) throws InsufficientAmountException, InvalidAccountNoException;
}
