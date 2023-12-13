package com.algo.housequest.models;

public class Place {
	
	int id;
	String type;
	String address;
	String placeDp;
	
	public Place(int id, String type, String address, String placeDp) {
		super();
		this.id = id;
		this.type = type;
		this.address = address;
		this.placeDp = placeDp;
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

	public String getPlaceDp() {
		return placeDp;
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

	public void setPlaceDp(String placeDp) {
		this.placeDp = placeDp;
	}

}
