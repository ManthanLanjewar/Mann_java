package com.daoserviceimpl;

import com.bean.Account;
import com.daoservices.AccountDAOServicesSummary;
import com.providers.Account_DBConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Java class for Implementing DAO Interface service methods
public class AccountDAOServiceImpl implements AccountDAOServicesSummary
{
	Connection con=Account_DBConnectionProvider.getDBConnection();
	PreparedStatement stmt;
	//,stmt1,stmt2,stmt3,stmt4
	Account acc=null;
	int updateCount=0;
	
	//Insert account Data into Database
	public int insertAccountData(Account acc) 
	{
		try {
			stmt=con.prepareStatement("insert into AccountTable values(accno,?,?)");
			//Account number is auto generated from database
			stmt.setString(1, acc.getType());
			stmt.setFloat(2, acc.getAmount());
			updateCount = stmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return updateCount;
	}
	//Method getAccountNumber for fetching account number of newly created account
	public int getAccountNumber()
	{
		ResultSet rs;
		try
		{
			stmt=con.prepareStatement("select * from AccountTable order by accNo DESC LIMIT 1");
			rs=stmt.executeQuery();
			//rs = stmt1.getResultSet();
			while(rs.next())
			{
				int accountNumber = rs.getInt(1);
				return accountNumber;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	//Checking validity of account
	public Account checkValidAccountNumber(int aNo)
	{		
		try {
			stmt = con.prepareStatement("select * from AccountTable where accno=?");
			stmt.setInt(1, aNo);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				String accType = rs.getString(2);
				float accBal = rs.getFloat(3);		
				acc = new Account(accType,accBal);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return acc;	
	}
	
	//method depositAmount for updating balance in database of certain account
	public int depositAmount(int accNo, float amount)
	{
		try 
		{
			stmt=con.prepareStatement("update AccountTable set amount=amount+? where accno=?; ");
			stmt.setFloat(1, amount);
			stmt.setInt(2, accNo); 
			updateCount = stmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return updateCount;    
		
	}
	//method withdrawAmount for updating balance in database of certain account
	public int withdrawAmount(int accNo, float amount)
	{
		try 
		{
			stmt=con.prepareStatement("update AccountTable set amount=amount-? where amount>? and accno=?; ");
			stmt.setFloat(1, amount);	//for withdrawal amount
			stmt.setFloat(2, amount);	//for checking insufficient amount condition
			stmt.setInt(3, accNo); 
			updateCount = stmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return updateCount; 
	}
	
	
	//Fetch account Data from Database 
		public Account getAccountDetails(int accNo) 
		{
			try
			{
				stmt=con.prepareStatement("select * from AccountTable where accno=?");
				stmt.setInt(1, accNo);
				ResultSet rs=stmt.executeQuery();

				rs.next();
				String accType = rs.getString(2);
				float accBal = rs.getFloat(3);		
				acc = new Account(accType,accBal);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return acc;
		}
}//End of class
