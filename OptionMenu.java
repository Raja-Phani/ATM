package com.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account
{
	Scanner menuInput=new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer,Integer> data= new HashMap<Integer,Integer>();
	
	
	public void getLogin() throws IOException
	{
		int x=1;
		do
		{
			try
			{
				data.put(90107848, 9876);
				data.put(8989898, 1890);
				
				System.out.println("Welcome to ATM Machine");
				
				System.out.println("Enter Customer Number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter Pin Number: ");
				setPinNumber(menuInput.nextInt());
			}
			catch(Exception e)
			{
				System.out.println("Invalid characters,Enter Only Numbers");
				x=2;
			}
			for(Entry<Integer, Integer> entry:data.entrySet())
			{
				if(entry.getKey()==getCustomerNumber() && entry.getValue()==getPinNumber())
				{
					getAccountType();
				}		
			}
			System.out.println("Wrong Customer Number or Pin Number");
		}while(x==1);
		
	}
	public void getAccountType() throws IOException
	{
		System.out.println("Select the Account you want to Access: ");
		System.out.println("Type 1 - Current Account");
		System.out.println("Type 2 - Savings Account");
		System.out.println("Type 3 - Exit");
		System.out.println("Choice: ");
		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1:
			getCurrent();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thank u for using this ATM, bye ");
			getLogin();
			break;
		default:
			System.out.println("Invalid Choice.");
			getAccountType();
			
		}
	}
	public void getCurrent() throws IOException
	{
		System.out.println("Current Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Money");
		System.out.println("Type 3 - Deposit Money");
		System.out.println("Type 4 - Exit");
		
		int selection = menuInput.nextInt();
		switch(selection)
		{
		case 1:
			System.out.println("Current Account Balance is: "+moneyFormat.format(getCurrentBalance()));
			getCurrent();
			break;
		case 2:
			getCurrentWithdrawInput();
			getCurrent();
			break;
		case 3:
			getCurrentDepositInput();
			getCurrent();
			break;
		case 4:
			System.out.println("Thank u for using this ATM, bye ");
			getLogin();
			break;
		default:
			System.out.println("Invalid Choice");
			getCurrent();
		}
	}
	
	public void getSaving() throws IOException
	{
		System.out.println("Savings Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Money");
		System.out.println("Type 3 - Deposit Money");
		System.out.println("Type 4 - Exit");
		
		int selection = menuInput.nextInt();
		switch(selection)
		{
		case 1:
			System.out.println("Savings Account Balance is: "+moneyFormat.format(getSavingBalance()));
			getSaving();
			break;
		case 2:
			getSavingWithdrawInput();
			getSaving();
			break;
		case 3:
			getSavingDepositInput();
			getSaving();
			break;
		case 4:
			System.out.println("Thank u for using this ATM, bye ");
			getLogin();
			break;
		default:
			System.out.println("Invalid Choice");
			getSaving();
		}
	}

}
