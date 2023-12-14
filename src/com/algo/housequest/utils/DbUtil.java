package com.algo.housequest.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.algo.housequest.models.Graph;
import com.algo.housequest.models.House;
import com.algo.housequest.models.Place;


public class DbUtil {

	DataSource dataSource;

	// Servlet will pass on the connection pool to the dataSource variable in
	// dbUtil class
	public DbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private void closeConnection(Connection myCon, Statement myStmt, ResultSet myRes) throws SQLException {
		try {
			if (myStmt != null) {
				myStmt.close();
			}
			if (myRes != null) {
				myRes.close();
			}
			if (myCon != null) {
				myCon.close();// this will not necessarily close the db connection but will return the
								// connection pool
			}
		} catch (Exception exec) {
			exec.printStackTrace();
		}
	}

	// findUser() method validates if the user already exists on the db
	public List<House> getAllHouses() throws Exception {
		
		List<House> houseList = new ArrayList<>();

		// initialize the sql attributes
		Connection myCon = null;
		PreparedStatement myStmt = null;
		ResultSet myRes = null;

		try {

			// create a connection
			myCon = dataSource.getConnection();

			// prepare the statement
			String query = "select * from house;";
			myStmt = myCon.prepareStatement(query);

			// execute query
			myRes = myStmt.executeQuery();

			// get the user details
			while (myRes.next()) {
				
				int id = Integer.parseInt(myRes.getString("house_id"));
				String type = myRes.getString("type");;
				String address = myRes.getString("address");
				String bath = myRes.getString("bath");
				String bedrooms= myRes.getString("bedrooms");
				String houseDp = myRes.getString("houseDp");
				
				House house = new House(id,type,address,bath,bedrooms,houseDp);
				
				houseList.add(house);
				
			}
			
			return houseList;
		}
		
		finally {
			closeConnection(myCon, myStmt, myRes);
		}

	}
	
public List<Place> getAllPlaces() throws Exception {
		
		List<Place> placeList = new ArrayList<>();

		// initialize the sql attributes
		Connection myCon = null;
		PreparedStatement myStmt = null;
		ResultSet myRes = null;

		try {

			// create a connection
			myCon = dataSource.getConnection();

			// prepare the statement
			String query = "select * from place;";
			myStmt = myCon.prepareStatement(query);

			// execute query
			myRes = myStmt.executeQuery();

			// get the user details
			while (myRes.next()) {
				
				int id = Integer.parseInt(myRes.getString("place_id"));
				String type = myRes.getString("type");
				String address = myRes.getString("address");
				String placeDp = myRes.getString("placeDp");
				
				Place place = new Place(id,type,address,placeDp);
				
				placeList.add(place);
				
			}
			
			return placeList;
		}
		
		finally {
			closeConnection(myCon, myStmt, myRes);
		}

	}

public List<Graph> getGraph() throws Exception {
	
	List<Graph> graphInput = new ArrayList<>();

	// initialize the sql attributes
	Connection myCon = null;
	PreparedStatement myStmt = null;
	ResultSet myRes = null;

	try {

		// create a connection
		myCon = dataSource.getConnection();

		// prepare the statement
		String query = "select * from source_dest_mapper;";
		myStmt = myCon.prepareStatement(query);

		// execute query
		myRes = myStmt.executeQuery();

		// get the user details
		while (myRes.next()) {
			
			int source_id = Integer.parseInt(myRes.getString("source_id"));
			int dest_id = Integer.parseInt(myRes.getString("destination_id"));
			int distance = Integer.parseInt(myRes.getString("distance"));
			
			Graph graph = new Graph(source_id,dest_id,distance);
			
			graphInput.add(graph);
			
		}
		
		return graphInput;
	}
	
	finally {
		closeConnection(myCon, myStmt, myRes);
	}

}

public List<House> getHouse(int destId) {
	return null;
}

}

	