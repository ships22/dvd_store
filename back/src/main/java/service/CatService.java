package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.CatDao;
import com.model.CatModel;

public class CatService {
	
	CatDao catDao = new CatDao();
	
	// get all category -
	public List<CatModel>getAllCat(){
		List<CatModel> catList = new ArrayList<CatModel>();
		catList.clear();
		try {
			catList = catDao.getAllCat();
		} catch(SQLException e) {
			e.printStackTrace();
		} return catList;
	}
	
	// create category - 
	public void saveCat(String category) {
		try {
			catDao.saveCat(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// delete category -
	public void deleteCat(int id) {
		try {
			catDao.deleteCat(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
