package com.internshala.javaapp;
import java.util.Scanner;

public class BalanceRelated {

	private int balance;
	Scanner scanner = new Scanner(System.in);

	protected BalanceRelated()
	{ }

	protected void setBalance(int Balance)
	{
		balance=Balance;
	}
	protected int BalanceLeft()
	{
		return balance;
	}
	protected void Balance()
	{
		System.out.println("Enter your Choice : \n 1 . Add Balance \n 2 . Withdraw Balance \n 3 . View Balance");
		int n = scanner.nextInt();
		switch(n)
		{
			case 1 : addBalance();
			         break;
			case 2 : withdrawBalance();
			          break;
			case 3 : viewBalance();
			         break;
			default:
				System.out.println("INVALID CHOICE !! \n");
		}
	}

	private void addBalance()
	{
		System.out.println("Enter money you want to add into your wallet : ");
		int n = scanner.nextInt();
		balance+=n;
		System.out.println("Updated Balance in your wallet :  "+balance+"\n");
	}

	private void withdrawBalance()
	{
		System.out.println("Enter the amount you want to withdraw from your wallet :  ");
		int n = scanner.nextInt();
		if(n>balance)
		{
			System.out.println("Wallet Balance is not enough to withdraw the money  !!"+"\n");
			return;
		}
		balance-=n;
		System.out.println("Balance left in your Wallet :  "+balance);
	}

	protected void viewBalance()
	{
		System.out.println("Avaiable Balance in your Wallet : "+balance);
	}


	protected void mobile()
	{
		System.out.println("Enter your Mobile no. : ");
		String num= scanner.next();
		System.out.println("Recharge Amount  :  ");
		int n = scanner.nextInt();
		if(n>balance)
		{
			System.out.println("Wallet Balance is not enough to recharge your Mobile  !!"+"\n");
			return;
		}
		balance-=n;
		System.out.println(" **** Recharge Successful on Mobile Number "+num+" **** \n\n  Balance Left in your Wallet : "+balance+"\n");
	}

}
