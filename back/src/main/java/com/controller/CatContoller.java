package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.CatModel;


import service.CatService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CatContoller {
	CatService catService = new CatService();
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = "application/json")
	public List<CatModel>getAllCat(){
		return catService.getAllCat();
	}

}
