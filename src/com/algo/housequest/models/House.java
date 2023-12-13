package com.algo.housequest.models;

public class House {
	
	int id;
	String type;
	String address;
	String bath;
	String bedrooms;
	String houseDp;
	
	public House(int id, String type, String address, String bath, String bedrooms,String houseDp) {
		super();
		this.id = id;
		this.type = type;
		this.address = address;
		this.bath = bath;
		this.bedrooms = bedrooms;
		this.houseDp = houseDp;
	}

	public String getHouseDp() {
		return houseDp;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getAddress() {
		return address;
	}

	public String getBath() {
		return bath;
	}

	public String getBedrooms() {
		return bedrooms;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBath(String bath) {
		this.bath = bath;
	}

	public void setBedrooms(String bedrooms) {
		this.bedrooms = bedrooms;
	}
	
	public void setHouseDp(String houseDp) {
		this.houseDp = houseDp;
	}

}
