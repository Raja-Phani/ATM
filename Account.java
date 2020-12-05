package com.atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account 
{
	Scanner input=new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
	
	private int customerNumber;
	private int pinNumber;
	private double currentBalance=0;
	private double savingBalance=0;
	
	public int setCustomerNumber(int customerNumber)
	{
		this.customerNumber=customerNumber;
		return customerNumber;
	}
	
	public int getCustomerNumber()
	{
		return customerNumber;	
	}
	
	public int setPinNumber(int pinNumber)
	{
		this.pinNumber=pinNumber;
		return pinNumber;
	}
	
	public int getPinNumber()
	{
		return pinNumber;
	}
	public double getCurrentBalance()
	{
		return currentBalance;
	}
	public double getSavingBalance()
	{
		return savingBalance;
	}
	
	public double calcCurrentWithdraw(double amount)
	{
		currentBalance=(currentBalance-amount);
		return currentBalance;
	}
	
	public double calcSavingWithdraw(double amount)
	{
		savingBalance=(savingBalance-amount);
		return savingBalance;
	}
	
	public double calcCurrentDeposit(double amount)
	{
		currentBalance=(currentBalance+amount);
		return currentBalance;
	}
	
	public double calcSavingDeposit(double amount)
	{
		savingBalance=(savingBalance+amount);
		return savingBalance;
	}
	
	public void getCurrentWithdrawInput()
	{
		System.out.println("Current Acccount Balance: "+moneyFormat.format(currentBalance));
		System.out.println("Amount you want to withdraw from checking account");
		double amount=input.nextDouble();
		if((currentBalance-amount)>=0)
		{
			calcCurrentWithdraw(amount);
			System.out.println("New Current Account balance: "+moneyFormat.format(currentBalance));
		}
		else
		{
			System.out.println("Insufficient Funds");
		}
	}
	public void getSavingWithdrawInput()
	{
		System.out.println("Savings Acccount Balance: "+moneyFormat.format(savingBalance));
		System.out.println("Amount you want to withdraw from Savings account");
		double amount=input.nextDouble();
		if((savingBalance-amount)>=0)
		{
			calcSavingWithdraw(amount);
			System.out.println("New Savings Account balance: "+savingBalance);
		}
		else
		{
			System.out.println("Insufficient Funds");
		}
	}
	public void getCurrentDepositInput()
	{
		System.out.println("Checking Acccount Balance: "+moneyFormat.format(currentBalance));
		System.out.println("Amount you want to deposit in cureent account");
		double amount=input.nextDouble();
		if((currentBalance+amount)>=0)
		{
			calcCurrentDeposit(amount);
			System.out.println("New Current Account balance is: "+moneyFormat.format(currentBalance));
		}
		else
		{
			System.out.println("Balance Can't be Negative ");
		}
	}
	public void getSavingDepositInput()
	{
		System.out.println("Savings Acccount Balance: "+moneyFormat.format(savingBalance));
		System.out.println("Amount you want to deposit in Savings account");
		double amount=input.nextDouble();
		if((savingBalance+amount)>=0)
		{
			calcSavingDeposit(amount);
			System.out.println("New Savings Account balance is: "+savingBalance);
			
		}
		else
		{
			System.out.println("Balance Can't be Negative");	
		}
	}
}