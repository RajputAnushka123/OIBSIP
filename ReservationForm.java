package util;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import bean.TrainDetails;
import bean.User;
import database.mysqlprocessing;

public class ReservationForm
{
	static Map<Integer, TrainDetails> trainDetailsMap = new HashMap<Integer, TrainDetails>();
	static {
		
		trainDetailsMap=mysqlprocessing.traindetailsinit();
	}

	public void reservationdetails(String loginUser) {
		System.out.println("User Details");
		System.out.println("Name:" + loginUser);
		
		System.out.println("Please Select Train Details");
		for (Map.Entry<Integer, TrainDetails> entry: trainDetailsMap.entrySet()) {
			System.out.println("trainNumber = " + entry.getKey() + 
                    ", " + entry.getValue()); 
		}
		int trainNumber;
		String pnrName;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Passenger Name");
		pnrName=sc.next();
		System.out.println("Enter the Train Number");
		trainNumber=sc.nextInt();
		System.out.println("Passenger Name="+ pnrName);
		System.out.println("TrainNumber="+ trainNumber);
		mysqlprocessing.trainSelection(trainNumber);
		TrainDetails booking=trainDetailsMap.get(trainNumber) ;
		mysqlprocessing.addBookingDetails(booking,pnrName);
	}

}
