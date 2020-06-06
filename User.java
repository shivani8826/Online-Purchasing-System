package com.internshala.javaapp;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public final class User extends BalanceRelated {

	private Map<String, String> m = new HashMap();

	static private Map<String, String> shoe = new LinkedHashMap();

	private String id, password, name, number;

	Scanner scanner = new Scanner(System.in);

	protected void UserRegister() {
		System.out.println("Enter your Name : ");
		String name = scanner.next();
		System.out.println("Enter your phone number : ");
		String phone = scanner.next();
		while (true) {
			boolean b = this.checkPhone(phone);
			if (b == false) {
				System.out.println("Entered phone number is not valid. Please try again!!");
				System.out.println("Re-Enter your phone number : ");
				phone = scanner.next();
				continue;
			} else
				break;
		}
		System.out.println("Set your ID : ");
		String id1 = scanner.next();
		System.out.println("Set your Password (Should contains min. of 10 length which includes \n                                 ------ Atleast one UpperCase(s) \n                                 ------ Atleast one LowerCase(s) \n                                 ------ Atleast one Special Character(s) ");
		String psswd1 = scanner.next();
		while (true) {
			boolean b = this.checkPassword(psswd1);
			if (b == false) {
				System.out.println("Set your Password (Should contains min. of 10 length which includes \n                                 ------ Atleast one UpperCase(s) \n                                 ------ Atleast one LowerCase(s) \n                                 ------ Atleast one Special Character(s) ");
				psswd1 = scanner.next();
				continue;
			} else
				break;
		}

		if (m.containsKey(id1)) {
			System.out.println("This ID already exist !! . Please try for another ID .");
			return;
		}

		this.id = id1;
		this.password = psswd1;
		m.put(id1, psswd1);
		this.name = name;
		this.number = phone;
		System.out.println("Registeration Successful !!");
	}

	protected boolean UserLogin() {
		System.out.println("Enter your ID : ");
		String c1 = scanner.next();
		System.out.println("Enter password :  ");
		String c2 = scanner.next();

		if (m.containsKey(c1)) {
			String check = m.get(c1);
			if (check.equals(c2)) {
				System.out.println(" - - SUCCESSFULLY LOGIN !! - -  ");
				return true;
			}
			System.out.println("OOPS !! Password is incorrect! ");
			return false;
		} else {
			System.out.println("This ID does'nt exist in our Database");
			return false;
		}
	}

	protected boolean checkPhone(String number) {
		if (number.length() == 10) {
			for (int i = 0; i < 10; i++) {
				if (number.charAt(i) >= '0' && number.charAt(i) <= '9')
					continue;
				else
					return false;
			}
			return true;
		}

		return false;

	}

	protected boolean checkPassword(String psswd) {
		int small = 0, upper = 0, num = 0, special = 0;
		if (psswd.length() < 10) {
			System.out.println("OOPS !! Password is too Short !! Try again !!\n");
			return false;
		}
		for (int i = 0; i < psswd.length(); i++) {
			if (psswd.charAt(i) >= 'a' && psswd.charAt(i) <= 'z')
				small = 1;
			else if (psswd.charAt(i) >= 'A' && psswd.charAt(i) <= 'Z')
				upper = 1;
			else if (psswd.charAt(i) >= '0' && psswd.charAt(i) <= '9')
				num = 1;
			else if (psswd.charAt(i) == '@' || psswd.charAt(i) == '$' || psswd.charAt(i) == '!' || psswd.charAt(i) == '&' || psswd.charAt(i) == '%' || psswd.charAt(i) == '*')
				special = 1;
		}

		if (small == 1 && upper == 1 && num == 1 && special == 1)
			return true;
		else {
			System.out.println("Entered Password is not valid. Please try again!!\n");
			return false;
		}
	}


	protected void Options() {
		System.out.println("**************************** \n\nChoose your Option : \n 1 . Payment \n 2 . View Your Profile \n 3 . Shopping \n 4 . Balance related query \n 5 . LogOut \n\n****************************");
		int n = scanner.nextInt();
		if (n == 5)
			return;
		do {
			switch (n) {
				case 1:
					mobile();
					break;

				case 2:
					printDetails();
					break;
				case 3:
					shoes();
					ShoesPerform();
					break;
				case 4:
					Balance();
					break;
				default:
					System.out.println(" You Entered an invalid Choose !! ");
			}
			System.out.println("**************************** \n\nChoose your Option : \n 1 . Payment \n 2 . View Your Profile \n 3 . Shopping \n 4 . Balance related query \n  5 . LogOut \n\n****************************");
			n = scanner.nextInt();
		} while (n != 5);
	}

	private void printDetails() {
		System.out.println("**************************** \n\nName : " + this.name + "\nPhone Number : " + this.number + "\nYour LoginID : " + this.id);
		viewBalance();
		System.out.println("\n\n****************************");
	}

	private final static void shoes() {

		String s[] = {"Nike", "Woodland", "Adidas", "SeeandWear", "LeeCooper", "Fila", "Puma", "RedTape", "Reebok", "Hush Puppies", "Bata", "Liberty", "Paragon", "Lancer", "Relaxo", "Hitz", "Tirubala", "Lakhani", "VKC", "Sparx", "Asics"};
		String[] arr = {"2000", "1900", "1500", "1000", "900", "950", "890", "890", "2000", "1000", "200", "1000", "350", "900", "1500", "450", "900", "200", "100", "600", "1200"};

		for (int i = 0; i < 21; i++) {
			shoe.put(s[i], arr[i]);
		}

		String[][] ans = new String[21][2];

		for (int i = 0; i < 21; i++) {
			ans[i][0] = s[i];
			ans[i][1] = arr[i];
		}

		new table(ans);
	}

	public void ShoesPerform() {
		System.out.println("Options : \n1. Purchase from this List Only.\n2. Want the shoes with your Range");
		int n = scanner.nextInt();
		if (n == 1) {option1();}
		else if(n==2){option2();}
		else{
			System.out.println("INVALID CHOICE !!");}
	}

	protected void option1()
	{
		String s1;
		while(true)
		{
			System.out.println("Choose your brand : ");
			s1 = scanner.next();
			if (shoe.containsKey(s1)) {
				String temp = shoe.get(s1);
				int num = Integer.parseInt(temp);
				int Balance = BalanceLeft();
				if (num > Balance) {
					System.out.println("Your Wallet is not having enough balance !!");
					return;
				}
				setBalance(Balance - num);
				System.out.println("****  You Successfully Purchased " + s1 + " Shoes" + " of Rs. " + temp + " **** \n\nYou are left with Wallet Balance as : " + BalanceLeft());
                return;
			} else
				System.out.println("ERROR!!!!!");
		}

	}
	protected void option2()
	{
		System.out.println("Choose Price Range  : \n1. Under Price Rs.500 \n2. Rs. 500 - Rs.1000 \n3. Rs.1000 - Rs.1500 \n4. Rs.1500 - Rs.2000");
		int n = scanner.nextInt();
		if(n==1)
			printRangeShoe(0,500);
		else if(n==2)
			printRangeShoe(500,1000);
		else if(n==3)
			printRangeShoe(1000,1500);
		else if(n==4)
			printRangeShoe(1500,2000);
		else
			System.out.println("INVALID CHOICE !!");

	}

	private final void printRangeShoe(int min,int max)
	{
		for(Map.Entry i:shoe.entrySet())
		{
	      int n = Integer.parseInt((String)i.getValue());
	      if(n>=min&&n<=max)
		      System.out.println(i.getKey()+"        ----------        Rs."+i.getValue());
		}

		option1();
	}
}

