package util;

import java.util.ArrayList;
import java.util.Scanner;

import bean.User;

public class HomePage {
	// static User user=new User();
	//static ArrayList<User> userlist = new ArrayList<User>();
	public boolean home() {
		int choice;
		while (true) {
			System.out.println("Enter Your Choice :");
			System.out.println("1. for Register ");
			System.out.println("2. for Login");
			System.out.println("3. for Exit");
			Scanner Sc = new Scanner(System.in);
			choice = Sc.nextInt();
			Register register = new Register();
			Login login = new Login();
			
			switch (choice) {
			case 1:
				register.registeruser();
				break;
			case 2:
				String loginUser=login.userlogin();
				if(loginUser!=null) {
					ReservationForm form=new ReservationForm();
					form.reservationdetails(loginUser);
				}
				break;
//			case 3 :
//				form.reservationdetails();
//				break;	
			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
   
	} 
}
