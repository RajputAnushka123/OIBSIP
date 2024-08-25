package util;

import java.util.Scanner;

import bean.User;
import database.mysqlprocessing;

public class Login {
	public String userlogin() {
		User loginuser = null;
		String username;
		String password;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your UserName:");
		username = sc.next();
		System.out.println("Enter Your Password");
		password = sc.next();
		mysqlprocessing obj=new mysqlprocessing();
		boolean flag=obj.checkuser(username,password);

		if (flag) {
			System.out.println("Login Successful");
			
		} else {
			System.out.println("Invalid UserName and Password");
		}
      return username;
	}
}
