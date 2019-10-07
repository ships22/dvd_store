package com.model;

public class UserModel {
	
	private  int 	 id;
	private  String firstName;
	private  String lastName;
	private  String houseNo;
	private  String street;
	private  String postCode;
	private  String country;
	private  int 	 isAdmin;
	private  String email;
	
	public UserModel() {
		super();
	}
	
	public UserModel(int id, String firstName, String lastName, String houseNo, String street, String postCode,
			String country, int isAdmin, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.houseNo = houseNo;
		this.street = street;
		this.postCode = postCode;
		this.country = country;
		this.isAdmin = isAdmin;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
