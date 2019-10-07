package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.DAO.UserDao;
import com.model.UserModel;



public class UserService {

	UserDao userDao = new UserDao();
	
	// create user -
	public void saveUser(String firstName, String lastName, String houseNo, String street, String post_code, String country, int is_Admin, String email) {
		try {
			userDao.saveUser(firstName, lastName, houseNo, street, post_code, country, is_Admin, email);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// get all user -
	public List<UserModel> getAlluser() {
		List <UserModel> userList = new ArrayList<UserModel>();
		userList.clear();
		try {
			userList = userDao.getAllUser();
		}catch (SQLException e) {
			e.printStackTrace();
		} return userList;
	}
	
	// get user by id -
	public List<UserModel> getUserbyId(int id){
		List<UserModel> userList = new ArrayList<UserModel>();
		userList.clear();
		try {
			userList = userDao.getUserById(id);
		}catch(SQLException e) {
			e.printStackTrace();
		} return userList;
	}
	
	// get user by id -
		public List<UserModel> getUserbyUserName(String email){
			List<UserModel> userList = new ArrayList<UserModel>();
			userList.clear();
			try {
				userList = userDao.getUserByEmail(email);
			}catch(SQLException e) {
				e.printStackTrace();
			} return userList;
		}
	
	// update user - 
	public void updateUser(String firstName, String lastName, String houseNo, String street, String post_code, String country, int is_Admin, String email, int id) {
		try {
			userDao.updateUser(firstName, lastName, houseNo, street, post_code, country, is_Admin, email, id);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// delete user -
	public void deleteUser(int id) {
		try { 
			userDao.deleteUser(id);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
