package com.Practice.DataLayer;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.Practice.User.User;


public class DataLayer {
	 Connection connection;
	
	public DataLayer() throws ClassNotFoundException, SQLException{
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userd", "root", "12345");
	 // System.out.println("Test"); 
	}
	//CRUD
	//C-> Create(Insert)
	//R-> Read(Select)
	//U-> Update(Modify)
	//D-> Delete 
	public  int insertUser(User user) throws SQLException {
		
		String sqlQuery="insert into userd.user (name,age,contact,password) values('"+user.getName()+ "', "+user.getAge()+", '"+user.getContact()+"', '"+user.getPassword()+"');";
        Statement stmt=connection.createStatement();
		return stmt.executeUpdate(sqlQuery);
		
	}
	
	public ArrayList<User> getAllUsers() throws SQLException {
	    ArrayList<User> users=new ArrayList<User>();
	    
		String sqlQuery="SELECT * FROM userd.user; ";
		Statement stmt=connection.createStatement();
		ResultSet resultSet=stmt.executeQuery(sqlQuery);
		
		while(resultSet.next()) {
			User user=new User();
			user.setId(resultSet.getInt("Id"));
			user.setName(resultSet.getString("name"));
			user.setAge(resultSet.getInt("Age"));
			user.setContact(resultSet.getString("Contact"));
			user.setPassword(resultSet.getString("Password"));
			users.add(user);
			}
		return users;
		
	}
	public int updateUser(User user) throws SQLException {
		String sqlQuery="UPDATE userd.user SET name = '"+user.getName()+ "',age = "+user.getAge()+",contact = '"+user.getContact()+"',password = '"+user.getPassword()+"'WHERE id = "+user.getId()+";";

		Statement stmt=connection.createStatement();
		return stmt.executeUpdate(sqlQuery);
	
	}
	
	/*
	 * public boolean saveUser(User user) throws SQLException { String
	 * query="INSERT INTO userd.user(name,age,contact,password)VALUES('"+user.
	 * getName()+"',"+user.getAge()+",'"+user.getContact()+"','"+user.getPassword()+
	 * "');";
	 * 
	 * Statement statement=null; boolean status=false;
	 * 
	 * if(user!=null) { int id=user.getId();
	 * 
	 * statement=connection.createStatement(); status= statement.execute(query); }
	 * return status; }
	 */
	
	public static void main(String []args) {
		
		try {
		    ArrayList<User> list= new DataLayer().getAllUsers();
			//User user=new User("", 0 , 00 , "0000000000","123");
			list.forEach(System.out::println);
			
			User user=list.get(1);
			user.setName(user.getName()+1);
			user.setAge(user.getAge()+2);
			user.setContact(user.getContact()+22);
			user.setPassword(user.getPassword()+user.getName());
			list.add(user);
			
			System.out.println(new DataLayer().updateUser(user));
			
		
		} catch (ClassNotFoundException e) {
		  	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
