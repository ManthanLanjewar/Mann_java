package com.Client;

import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

public class GetNote 
{
	//method for connecting project with browser or URL.
	public void setUrl(String url)
	{
		try {
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI(url);
			  //URI oURL = new URI("http://www.yahoo.com");
			  desktop.browse(oURL);
			} catch (Exception e) {
			  e.printStackTrace();
			}
	}
	public void notes()
	{
		Scanner sc = new Scanner(System.in);
		String url;
		int sem;
		
		do{
		System.out.print("ENTER THE SEMESTER\n");
		System.out.print("1. 1ST SEMESTER\n2. 2ND SEMESTER\n3. 3RD SEMESTER\n4. 4TH SEMESTER\n");
		System.out.print("5. 5TH SEMESTER\n6. 6TH SEMESTER\n7. 7TH SEMESTER\n8. 8TH SEMESTER\n");
		System.out.println("9. EXIT");
		sem = sc.nextInt();
				
		switch(sem)
		{
		case 1:
			url = "https://drive.google.com/open?id=1lw6xG_38KdD4JcVBHlMeBIEFdl-SFzFP";
			setUrl(url);
			break;
		case 2:
			url = "https://drive.google.com/open?id=1L_QAdWZ736XhTgjeoPThz4YVQfFxBO9W";
			setUrl(url);
			break;
		case 3:
			url = "https://drive.google.com/open?id=1d8Xcp6K5_gOamJuSYDgRMfJcMx_z9Ic7";
			setUrl(url);
			break;
		case 4:
			url = "https://drive.google.com/open?id=16KzskHouGmfGNB_synXrbs7OqBCZ0VUN";
			setUrl(url);
			break;
		case 5:
			url = "https://drive.google.com/open?id=1obBFpXi_puqLgRHbDOnA2F1OiiFNtDGB";
			setUrl(url);
			break;
		case 6:
			url = "https://drive.google.com/open?id=1HHXhj3t0m9sGRWA98ARf86nOOYqTgAEY";
			setUrl(url);
			break;
		case 7:
			url = "https://drive.google.com/open?id=1rv30q9oPDSn2ikjqsufUnmVUzAQCt6vN";
			setUrl(url);
			break;
		case 8:
			url = "https://drive.google.com/open?id=1JOmJMYsQxDZRQjEDCyIvOhVxtRCTGCYV";
			setUrl(url);
			break;
		case 9:
			System.out.println("Thank you for your visit");
			break;
		default :
			System.out.println("Invalid option");
			break;
		}
		
		}while(sem != 9);
		sc.close();
	}
	
}
