package com.controller;



import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import service.*;
import com.model.DvdModel;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DvdController {
	DvdService dvdService = new DvdService();
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public List<DvdModel> home(){
		return dvdService.getDvdList();	
	}
	@RequestMapping(value = "/byid/{id}", method = RequestMethod.GET, produces = "application/json")
	public DvdModel getById(@PathVariable("id") int id){
		return dvdService.getById(id);
	}
	
	@RequestMapping(value = "/byprice", method = RequestMethod.GET, produces = "application/json")
	public List<DvdModel> getByPrice(){
		return dvdService.getByPrice();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public void save(@RequestBody DvdModel dvd) {
		System.out.println("touched post...");
		String cat_id_str = dvd.getCat();
		int cat_id_int = Integer.parseInt(cat_id_str);
		dvdService.saveDvd(dvd.getName(), dvd.getPrice(), cat_id_int, dvd.getImage());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public void update(@RequestBody DvdModel dvd, @PathVariable("id") int id) {
		System.out.println("here...");
		String cat_id_str = dvd.getCat();
		int cat_id_int = Integer.parseInt(cat_id_str);
		dvdService.updateDvd(dvd.getName(), dvd.getPrice(), cat_id_int, dvd.getName(), id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public List<DvdModel> delete(@PathVariable("id") int id) {
		dvdService.deleteDvd(id);
		return dvdService.getDvdList();
	}

}
