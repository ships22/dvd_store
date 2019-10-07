package com.DAO;

import com.model.*;
import com.DbUtils.DBUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DvdDao {
	private final String CREATE 	= "INSERT INTO dvd_stock (NAME, PRICE, CAT_ID, IMAGE) VALUES (?, ?, ?, ?)";
	private final String UPDATE	 	= "UPDATE dvd_stock SET NAME = ?, PRICE = ?, CAT_ID = ?, IMAGE = ? WHERE dvd_stock.ID = ?";
	private final String DELETE 	= "DELETE FROM dvd_stock WHERE dvd_stock.ID = ?";
	private final String GET_BY_CAT = "SELECT d.ID, NAME, PRICE, CATEGORY, IMAGE FROM dvd_stock d INNER JOIN movie_cat m ON d.CAT_ID = m.ID WHERE d.CAT_ID = ?";
	private final String PRICE_DEC	= "SELECT d.ID, NAME, PRICE, CATEGORY, IMAGE FROM dvd_stock d INNER JOIN movie_cat m ON d.CAT_ID = m.ID ORDER BY PRICE";
	private final String GET_ALL	= "SELECT d.ID, NAME, PRICE, CATEGORY, IMAGE FROM dvd_stock d INNER JOIN movie_cat m ON d.CAT_ID = m.ID ORDER BY d.ID";
	private final String GET_BY_ID = "SELECT d.ID, NAME, PRICE, CATEGORY, IMAGE FROM dvd_stock d INNER JOIN movie_cat m ON d.CAT_ID = m.ID WHERE d.ID = ?";
	Connection connection			= DBUtils.getConnection();
	
	//creating dvd - 
	public void createDvd(String name, int price, int cat_id, String image) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE);
		ps.setString(1, name);
		ps.setInt(2, price);
		ps.setInt(3, cat_id);
		ps.setString(4, image);
		ps.executeUpdate();
		System.out.println("new Dvd added.");
	}
	
	// get all dvd -
	public List<DvdModel> allDvd() throws SQLException {
		List<DvdModel> dvdList = new ArrayList<DvdModel>();
		PreparedStatement ps   = connection.prepareStatement(GET_ALL);
		ResultSet 		  rs   = ps.executeQuery();
		dvdList.clear();
		while(rs.next()) {
			dvdList.add(buildDvd(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		}
		return dvdList;
	}
	
	//get by id - 
	public DvdModel byId(int id) throws SQLException {
		DvdModel dvd = null;
		PreparedStatement ps 	  = connection.prepareStatement(GET_BY_ID);
		ps.setInt(1, id);
		ResultSet		  rs	  = ps.executeQuery();
	
		while(rs.next()) {
			dvd = new DvdModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
		}
		
		return dvd;
	}
	
	// get by category - 
	public List<DvdModel> getByCat(int cat_id) throws SQLException {
		List<DvdModel> dvdListCat = new ArrayList<DvdModel>();
		PreparedStatement ps 	  = connection.prepareStatement(GET_BY_CAT);
		ps.setInt(1, cat_id);
		ResultSet		  rs	  = ps.executeQuery();
		dvdListCat.clear();
		while(rs.next()) {
			dvdListCat.add(buildDvd(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		}
		
		return dvdListCat;
	}
	
	// update dvd - 
	public void updateDvd(String name, int price, int cat, String image, int id) throws SQLException {
		PreparedStatement ps 	  = connection.prepareStatement(UPDATE);
		ps.setString(1, name);
		ps.setInt(2, price);
		ps.setInt(3, cat);
		ps.setString(4, image);
		ps.setInt(5, id);
		ps.executeUpdate();
		System.out.println("Dvd has been updated.");
	} 
	
	// get by price order - 
	public List<DvdModel> getPriceDec() throws SQLException {
		List<DvdModel> dvdPriceDec = new ArrayList<DvdModel>();
		PreparedStatement ps	   = connection.prepareStatement(PRICE_DEC);
		ResultSet		  rs	   = ps.executeQuery();
		dvdPriceDec.clear();
		while(rs.next()) {
			dvdPriceDec.add(buildDvd(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		}
		return dvdPriceDec;
	}
	
	// delete dvd - 
	public void deleteDvd(int id) throws SQLException{
		PreparedStatement 	ps = connection.prepareStatement(DELETE);
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Dvd no " + id + " has been deleted from database.");
	}
	
	//dvd builder method -
	public DvdModel buildDvd(int id, String name, int price, String cat, String image) {
		  return new DvdModel(id, name, price, cat, image);
	}
		

}
