package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.DAO.DvdDao;
import com.model.DvdModel;


public class DvdService {
	
	DvdDao dvdDao = new DvdDao();
	
	
	// get all dvd -
	public List<DvdModel>getDvdList(){
		List<DvdModel>dvdList = new ArrayList<DvdModel>();
		dvdList.clear();
		try {
			dvdList = dvdDao.allDvd();
			System.out.println("dvd List displayed...");
			for(DvdModel dvd: dvdList) {
				System.out.println(dvd.getImage());
				System.out.println(dvd.getImage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return dvdList;
	}
	
	//get by id - 
	public DvdModel getById(int id){
		
		DvdModel dvd = null;
		try {
			dvd = dvdDao.byId(id);
			System.out.println("dvd getting by id...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return dvd;
	}
	
	
	// get dvd by price descending -
	public List<DvdModel>getByPrice(){
		List<DvdModel>dvdList = new ArrayList<DvdModel>();
		dvdList.clear();
		try {
			dvdList = dvdDao.getPriceDec();
			System.out.println("dvd List ordered by price...");
		} catch (SQLException e) {
			e.printStackTrace();
		} return dvdList;
	}
	
	// creating dvd -
	public void saveDvd(String name, int price, int cat_id, String image) {
		try {
			dvdDao.createDvd(name, price, cat_id, image);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//updating dvd - 
	public void updateDvd(String name, int price, int cat_id, String image, int id) {
		try {
			dvdDao.updateDvd(name, price, cat_id, image, id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	// deleting dvd -
	public void deleteDvd(int id) {
		try {
			dvdDao.deleteDvd(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}















