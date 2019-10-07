package com.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DbUtils.DBUtils;
import com.model.UserModel;

public class UserDao {
	
	private final String CREATE    		= "INSERT INTO user (firstName, lastName, houseNo, street, post_code, country, is_Admin, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE    		= "UPDATE user SET firstName = ?, lastName = ?, houseNo = ?, street = ?, post_code, country = ?, is_Admin = ?, email = ? WHERE user.ID = ?";
	private final String DELETE    		= "DELETE FROM user WHERE user.ID = ?";
	private final String GET_ALL   		= "SELECT * FROM user";
	private final String GET_BY_ID 		= "SELECT * FROM user WHERE user.ID = ?";
	private final String GET_BY_EMAIL 	= "SELECT * FROM user WHERE email = ?";
	Connection 		connection   = DBUtils.getConnection();
    
	// create user -
	public void saveUser(String firstName, String lastName, String houseNo, String street, String post_code, String country, int is_Admin, String email) throws SQLException {
		PreparedStatement ps  = connection.prepareStatement(CREATE);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, houseNo);
		ps.setString(4, street);
		ps.setString(5, post_code);
		ps.setString(6, country);
		ps.setInt(7, is_Admin);
		ps.setString(8, email);
		ps.executeUpdate();
		System.out.println("New user added.");
	}
	
	// update user - 
	public void updateUser(String firstName, String lastName, String houseNo, String street, String post_code, String country, int is_Admin, String email, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, houseNo);
		ps.setString(4, street);
		ps.setString(5, post_code);
		ps.setString(6, country);
		ps.setInt(7, is_Admin);
		ps.setNString(8, email);
		ps.setInt(9, id);
		ps.executeUpdate();
		System.out.println("User has been updated successfully");
	}
	
	// delete user - 
	public void deleteUser(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE);
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println(id + " User has been deleted.");	
	}
	
	// get all user -
	public List<UserModel> getAllUser() throws SQLException {
		List<UserModel> allUser = new ArrayList<UserModel>();
		PreparedStatement ps = connection.prepareStatement(GET_ALL);
		ResultSet rs = ps.executeQuery();
		allUser.clear();
		while(rs.next()) {
			allUser.add(buildUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
		}
		return allUser;
	}
	
	// get user by id - 
	public List<UserModel> getUserById(int id) throws SQLException {
		List<UserModel> user = new ArrayList<UserModel>();
		PreparedStatement ps = connection.prepareStatement(GET_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		user.clear();
		user.add(buildUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
		return user;
	}
	
	// get user by email - 
		public List<UserModel> getUserByEmail(String email) throws SQLException {
			List<UserModel> user = new ArrayList<UserModel>();
			PreparedStatement ps = connection.prepareStatement(GET_BY_EMAIL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			user.clear();
			user.add(buildUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
			return user;
		}
	
	// build user -
	public UserModel buildUser(int id, String firstName, String lastName, String houseNo, String street, String post_code, String country, int is_Admin, String email) {
		return new UserModel(id, firstName, lastName, houseNo, street, post_code, country, is_Admin, email);
	}
}
