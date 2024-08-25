
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import bean.TrainDetails;
import bean.User;
import util.ReservationForm;

public class mysqlprocessing {
	
	public Connection mysqlconnectivity() {
		String jdbcURL = "jdbc:mysql://localhost:3306/trainreservation";
		String username = "root";
		String password = "root";
		Connection conn = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcURL, username, password);

			Statement statement = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	public void adduser(User loginuser) {
		mysqlprocessing mysql = new mysqlprocessing();
		Connection conn = mysql.mysqlconnectivity();
		try {
			String sql = "INSERT INTO user (name,username,password,mobileno,gender,email) VALUES(?,?,?,?,?,?) ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, loginuser.getName());
			statement.setString(2, loginuser.getUsername());
			statement.setString(3, loginuser.getPassword());
			statement.setString(4, loginuser.getMobileno());
			statement.setString(5, loginuser.getGender());
			statement.setString(6, loginuser.getEmail());
			statement.executeUpdate();
			System.out.println("User Add");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		mysqlprocessing mysql = new mysqlprocessing();
		mysql.mysqlconnectivity();
	}

	public boolean checkuser(String username, String password) {
		// TODO Auto-generated method stub
		mysqlprocessing mysql = new mysqlprocessing();
		Connection conn = mysql.mysqlconnectivity();
		try {
			String select = "Select * from user where username=? and password=?";
			PreparedStatement stmt = conn.prepareStatement(select);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				System.out.println(result.getString("name"));
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static Map<Integer, TrainDetails> traindetailsinit() {
		Map<Integer, TrainDetails> traindetails=new HashMap<Integer, TrainDetails>();
		mysqlprocessing mysql = new mysqlprocessing();
		Connection conn = mysql.mysqlconnectivity();
		String selectdetails="Select * from traindetails";
		try {
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(selectdetails);
			while(result.next()) {
				TrainDetails train=new TrainDetails();
				train.setTrainNumber(result.getInt("trainNumber"));
				train.setTrainName(result.getString("trainName"));
				train.setClassType(result.getString("classType"));
				train.setJournyDate(result.getDate("journyDate"));
				train.setFrom(result.getString("from"));
				train.setTo(result.getString("to"));
				traindetails.put(train.getTrainNumber(), train);
				System.out.println(result.getInt("trainNumber"));
				System.out.println(result.getString("trainName"));
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return traindetails;
	}
	public static void trainSelection(int trainNum) {
		//String trainName="",classType="",journeyDate="",from="",to="";
		mysqlprocessing mysql = new mysqlprocessing();
		Connection conn = mysql.mysqlconnectivity();
		
		try {
			String Select="Select * from traindetails where trainNumber=?";
			PreparedStatement stmt = conn.prepareStatement(Select);
			stmt.setInt(1, trainNum);
			ResultSet result=stmt.executeQuery();
			while(result.next()) {
			System.out.println("TrainName  = "+result.getString(2));
			System.out.println("ClassType  = "+result.getString(3));
			System.out.println("JournyDate = "+result.getString(4));
			System.out.println("From  = "+result.getString(5));
			System.out.println("To  = "+result.getString(6));
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		//String [] s={trainName,classType,journyDate,from,to};
		//return s  ;
		
	}
	public static void addBookingDetails(TrainDetails booking, String pnrName) {
	    mysqlprocessing mysql = new mysqlprocessing();
	    Connection conn = mysql.mysqlconnectivity();
	    try {
	        String sql = "INSERT INTO reservation (passengerName, trainNumber, trainName, classType, journyDate, `from`, `to`) VALUES(?,?,?,?,?,?,?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, pnrName);
	        statement.setInt(2, booking.getTrainNumber());
	        statement.setString(3, booking.getTrainName());
	        statement.setString(4, booking.getClassType());
	        statement.setDate(5, booking.getJournyDate());
	        statement.setString(6, booking.getFrom());
	        statement.setString(7, booking.getTo());
	        statement.executeUpdate();
	        
	        System.out.println("Ticket Booked");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
