import java.io.*;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SQLHandler {

	private static Connection connection;
	private static Statement statement;
	private static SQLHandler SQLInstance = null;
	
	public static SQLHandler getInstance() throws FileNotFoundException, SQLException{
		if(SQLInstance == null){
			SQLInstance = new SQLHandler();
		}	
		return SQLInstance;
	}
	
	
	private SQLHandler() throws FileNotFoundException, SQLException{
		String strConnection = "jdbc:mysql://localhost:3306/?user=root&password=root";
		
		try{
			connection = DriverManager.getConnection(strConnection);
			statement = connection.createStatement();
			setUpDatabase();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private void setUpDatabase() throws SQLException{
		try{
			statement.execute("USE SangguRecWeekdb");
		}catch(Exception e){
			System.out.println("database not found");
			System.out.println("creating new database");
			createDatabase();
			
		}
	}
	
	private void createDatabase() throws SQLException{
		String createDatabase = "CREATE DATABASE SangguRecWeekdb";
		String createMemberTable =  "CREATE TABLE `Member` ("
				+ "id_number VARCHAR(6) PRIMARY KEY UNIQUE NOT NULL,"
				+ "nick_name VARCHAR(255) NOT NULL,"
				+ "first_name VARCHAR(255) NOT NULL,"
				+ "middle_name VARCHAR(255) NOT NULL,"
				+ "last_name VARCHAR(255) NOT NULL,"
				+ "birthday DATE NOT NULL,"
				+ "year VARCHAR(6) NOT NULL,"
				+ "course VARCHAR(15) NOT NULL,"
				+ "num VARCHAR(15) NOT NULL,"
				+ "email VARCHAR(50) NOT NULL,"
				+ "scholar TINYINT(1) NOT NULL,"
				+ ");";
		
		
		statement.execute(createDatabase);
		System.out.println("Database Created!");
		statement.execute("USE psycheRecWeekdb"); 
		
		statement.execute(createMemberTable);
		System.out.println("Table Created!");
	
	}
	
	public void insertMember(String id, String nname, String fname, String mname, String lname, String birthday, String year, String course, String contact, String email) throws SQLException{
		int s,r,m,p,mark,spo,mus;
		s = 0;
		r = 0;
		m = 0;
		p = 0;
		mark = 0;
		spo = 0;
		mus= 0;
		
		String insert = "INSERT INTO member " + 
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
				
		
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, nname);
			preparedStatement.setString(3, fname);
			preparedStatement.setString(4, mname);
			preparedStatement.setString(5, lname);
			preparedStatement.setString(6, birthday);
			preparedStatement.setString(7, year);
			preparedStatement.setString(8, course);
			preparedStatement.setString(9, contact);
			preparedStatement.setString(10, email);
			preparedStatement.executeUpdate();
		
		//System.out.println(id+ " "+ nname+" "+fname+" " +mname+" " +lname+" " +birthday+" " +year+" " +course+" " +block+" " +contact+" " +email+" "+ s+r+m+p+mark+spo +"!!!" );
	
		
	}
	
	
	
	
	
}
