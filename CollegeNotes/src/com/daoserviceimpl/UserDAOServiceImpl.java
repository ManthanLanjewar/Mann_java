package com.daoserviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.User;
import com.daoservices.UserDAOServicesSummary;
import com.providers.User_DBConnectionProvider;

public class UserDAOServiceImpl implements UserDAOServicesSummary
{
	Connection con=User_DBConnectionProvider.getDBConnection();
	User user=null;
	PreparedStatement stmt,stmt1;
	Statement stmt2;
	int count;
	
	public int insertUserData(User U) 
	{
		try{
			stmt=con.prepareStatement("insert into User values(?,?,?,?)");
			stmt.setString(1, U.getUsername());
			stmt.setString(2, U.getPass());
			stmt.setString(3, U.getsecurityQue());
			stmt.setString(4, U.getsecurityAns());
			count  = stmt.executeUpdate();
			return count;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	//boolean return type because if username or password found it returns True else returns false
	
	//checkUsernamePassword method for checking username and password
	public User checkUsername(String username)
	{
		try{
			stmt2= con.createStatement();
			ResultSet rs = stmt2.executeQuery("select * from User where username='"+username+"';");
			while(rs.next())
			{
				String username1=rs.getString(1);
				String pass1=rs.getString(2);
				String secQue=rs.getString(3);
				String secAns=rs.getString(4);
				user = new User(username1, pass1, secQue, secAns);
				return user;
			}	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean checkPassword(String pass)
	{
		try{
			stmt2= con.createStatement();
			ResultSet rs = stmt2.executeQuery("select * from User where username='"+pass+"';");
			while(rs.next())
			{
				return true;
			}	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	//checkSecurityQue method for checking security Question
	public boolean checkSecurityQue(String username ,String securityQue)
	{
		try{
			stmt2= con.createStatement();
			ResultSet rs = stmt2.executeQuery("select * from User where username='"+securityQue+"';");
			while(rs.next())
			{
				return true;
			}	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	//checkSecurityAns method for checking security Answer
	public boolean checkSecurityAns(String username ,String securityAns)
	{
		try{
			stmt2= con.createStatement();
			ResultSet rs = stmt2.executeQuery("select * from User where username='"+securityAns+"';");
			while(rs.next())
			{
				return true;
			}	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int changePassword(String username, String pass)
	{
		try {
			stmt=con.prepareStatement("update user set password=? where username=?; ");
			stmt.setString(1, pass);
			stmt.setString(2, username); 
			int updateCount = stmt.executeUpdate();
			return updateCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
