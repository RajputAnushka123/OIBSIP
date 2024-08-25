package util;

import java.util.Scanner;

import bean.User;
import database.mysqlprocessing;

public class Register {
	 
  public void registeruser() {
	     String name;
	     String username;
	     String password;
	     String mobileno;
	     String gender;
	     String email;
	     int choice;
	     User user=new User();
	    Scanner sc=new Scanner(System.in);
	   
	    System.out.println("Enter Your Name:");
	    name=sc.next();
	    user.setName(name);
	    System.out.println("Enter Your Email:");
	    email=sc.next();
	    user.setEmail(email);
	    System.out.println("Enter Your Mobile Number:");
	    mobileno=sc.next();
	    user.setMobileno(mobileno);
	    System.out.println("Slect Your Gender:");
	    System.out.println("1.for Male");
	    System.out.println("2. for Female");
	    System.out.println("3. for Other");
	    choice=sc.nextInt();
	 
	    
	    switch (choice) {
		case 1:
			user.setGender("Male");
			break;
		case 2:
			user.setGender("Female");
			break;
		case 3:
			user.setGender("Other");
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
	    System.out.println("Enter Your Username:");
	    username=sc.next();
	    user.setUsername(username);
	    
	    System.out.println("Enter Your Password:");
	    password=sc.next();
	    user.setPassword(password);
	   
	    System.out.println("Register Successful");
	    mysqlprocessing mysql=new mysqlprocessing();
	    mysql.adduser(user);
	    //HomePage.userlist.add(user);
	    
  }
}
