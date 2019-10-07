package com.model;

public class DvdModel {
	private int id;
	private String name;
	private int	   price;
	private String cat;
	private String image;
	
	public DvdModel(int id, String name, int price, String cat, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cat = cat;
		this.image = image;
	}
	
	public DvdModel() {}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCat() {
		return cat;
	}


	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getImage() {
		return image;
	};

	public void setImage(String image) {
		this.image = image;
	}

	
	
}
