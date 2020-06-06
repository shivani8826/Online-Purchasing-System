package com.internshala.javaapp;


import sun.plugin2.liveconnect.JSExceptions;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


		System.out.println("WELCOME IN OUR PAYTM SYSTEM !!");
		try {
			System.out.println("------------------------------\n Enter the option you want \n 1 . User login \n 2 . User SignUp \n 3 . Exit \n ---------------------------- ");
			Scanner scanner = new Scanner(System.in);
			int n = scanner.nextInt();

			User u1 = new User();
			do {

				switch (n) {
					case 1:
						boolean b = u1.UserLogin();
						if(b==true)
						   u1.Options();

						break;
					case 2:
						u1.UserRegister();
						break;
					case 3 : return;
					default:
						System.out.println("You have entered a wrong choice \n!!");
						return;

				}
				System.out.println("------------------------------\n Enter the option you want \n 1 . User login \n 2 . User SignUp \n 3 . Exit \n ----------------------------- ");

				n = scanner.nextInt();
			} while (n != 4);

		} catch (Exception e) {
			System.out.println("INVALID CHOICE !!");
			return;
		}
	}
}