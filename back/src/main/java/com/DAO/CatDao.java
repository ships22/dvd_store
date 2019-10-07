package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DbUtils.DBUtils;
import com.model.CatModel;

public class CatDao {
	
	private final String CREATE  = "INSERT INTO movie_cat (CATEGORY) VALUES (?)";
	private final String DELETE  = "DELETE FROM movie_cat WHERE ID = ?";
	private final String GET_ALL = "SELECT * FROM movie_cat";
	
	
	Connection		connection	 = DBUtils.getConnection();
	
	// create category -
	public void saveCat(String category) throws SQLException{
		PreparedStatement 	ps   = connection.prepareStatement(CREATE);
		ps.setString(1, category);
		ps.executeUpdate();
		System.out.println("New category added.");
	}
	
	// getting all category -
	public List<CatModel>getAllCat() throws SQLException{
		List<CatModel>catList = new ArrayList<CatModel>();
		catList.clear();
		PreparedStatement 	ps  = connection.prepareStatement(GET_ALL);
		ResultSet 			rs  = ps.executeQuery();
		while(rs.next()) {
			catList.add(buildCat(rs.getInt(1), rs.getString(2)));
		} return catList;
	}
	
	// delete category - 
	public void deleteCat(int id) throws SQLException {
		PreparedStatement   ps  = connection.prepareStatement(DELETE);
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println(id + " No Category has been deleted.");
	}
	
	// building category -
	public CatModel buildCat(int id, String category) {
		return new CatModel(id, category);
	}

}
