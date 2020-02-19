package com.providers;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//Java class for Providing Connection of Database Software with Java Program(Eclipse) 
public class DBConnectionProvider 
{
    public static Connection getDBConnection()
    {
    	Connection con=null;
    	try
    	{
			FileInputStream fis=new FileInputStream(".//Databaseconfig.properties");
			Properties p=new Properties();
			p.load(fis);
			String driver=p.getProperty("driver");
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			//create database connection
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
    }
}
