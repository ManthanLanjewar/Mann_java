 package com.Client;

	import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.exception.InvalidPassword;
import com.exception.InvalidSecurityAnswer;
import com.exception.InvalidUsername;
import com.providers.UserServiceProvider;
import com.services.UserServicesSummary;

	public class EAD_class {
		public static void main(String[] args) throws InterruptedException {

	       Scanner sc=new Scanner(System.in);
	       UserServicesSummary u= UserServiceProvider.createObjectUser();
	       int option;
	       String uName, pass, secQue, secAns, tempP;
	       System.out.println("\t\tWELCOME TO EAD\n\t  EASILY ACCESSIBLE DOCUMENT");
	       TimeUnit.SECONDS.sleep(5);
	do{   
	System.out.println("	ENTER YOUR CHOICE!");
	System.out.println("	1. SIGN UP");
	System.out.println("	2. SIGN IN");
	System.out.println("	3. FORGET PASSWORD");
	System.out.println("	4. CHANGE PASSWORD");
	System.out.println("	5. EXIT");
	//option = sc.nextInt();
	option = Integer.parseInt(sc.nextLine());
	       
	
	
	switch (option) {
	case 1:System.out.print("\n		Enter the Username: ");
	       uName= sc.nextLine();
	       System.out.print("		Enter the Password: ");
	       pass= sc.nextLine();
	       System.out.print("		Enter the Security Question: ");
	       secQue= sc.nextLine();
	       System.out.print("		Enter the Security Answer: ");
	       secAns= sc.nextLine();
	       u.signUp(uName, pass, secQue, secAns );
	       break;
	            
	case 2:
			boolean sign;
	       System.out.print("\n		Enter the Username: ");
	       uName= sc.next();
	       System.out.print("		Enter the Password: ");
	       pass= sc.next();
	       try {
				sign = u.signIn(uName,pass);
				if(sign)
				{
					GetNote g = new GetNote();
					g.notes();
				}
			}
			catch (InvalidUsername e)
			{e.printStackTrace();} 
			catch (InvalidPassword e)
			{e.printStackTrace();} 
	       
	       break;
	            
	case 3:
	       System.out.print("		Enter the Username: ");
	       uName= sc.next();
	       System.out.print("		Enter the Security Answer: ");
	       secAns= sc.next();
	       String newPassord;
			try {
				tempP = u.forgetPassword(uName,  secAns);
				System.out.println("		Enter the New Password: ");
				newPassord = sc.next();
				u.changeForgetPassword(uName, tempP, newPassord);
			} 
			catch (InvalidUsername e)
			{e.printStackTrace();}
			
			catch (InvalidSecurityAnswer e)
			{e.printStackTrace();}
	      
			break;
	            
	case 4:
			System.out.print("		Enter the Username: ");
	       uName= sc.next();
	       System.out.print("		Enter the Password: ");
	       pass= sc.next();
			String newPass = sc.next();
			try
			{
				u.changePassword(uName, pass, newPass);
			} 
			catch (InvalidUsername e) 
			{e.printStackTrace();} 
			catch (InvalidPassword e)
			{e.printStackTrace();}
			break;
	            
	case 5:
	       System.out.println("Thank You! For Your Visit");
	       break;

	default:
	       System.out.println("Unknown/Invalid Option");
	       break;
	}       
	}
	while(option != 5);

	sc.close();
	    }
	
}

	