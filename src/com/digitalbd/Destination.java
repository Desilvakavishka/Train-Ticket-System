// Dias D.D.K.S.
// IT21220760
// SE/OOP_MLB_WD_2022_S2_183

package com.digitalbd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import TicketSystemInterface.DatabaseModel;


// declaring class
public class Destination implements DatabaseModel {
	
	// declaring and assigning class properties
	private String table_name = "destinations";
	private int rs;
	private DBConnect db;
	public String id,station_from,station_to,train_id,time,status,fare,last_activity,last_modify_by,total_seat,seat_range,type;

// class constructor 
	public Destination() {
		id=station_from=station_to=train_id=time=status=fare=last_activity=last_modify_by=total_seat=seat_range=type = "";
		db = DBConnect.getInstance();
	}

	// overloaded constructor
	public Destination(String argId) {
		db = DBConnect.getInstance();
		// declaring query phrase
		String sql = "SELECT * FROM "+this.GetTableName()+" WHERE id = '"+argId+"'";
		try {
			ResultSet result = this.db.statement.executeQuery(sql);
			if(result.next()) {
				// assigning values
				this.id = result.getString("id");
				this.station_from = result.getString("station_from");
				this.station_to = result.getString("station_to");
				this.train_id = result.getString("train_id");
				this.time = result.getString("time");
				this.status = result.getString("status");
				this.fare = result.getString("fare");
				this.last_activity = result.getString("last_activity");
				this.last_modify_by = result.getString("last_modify_by");
				this.total_seat = result.getString("total_seat");
				this.seat_range = result.getString("seat_range");
				this.type = result.getString("type");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// get all method for returning property values
	public ArrayList<HashMap<String,String>> getAll(String stationFrom ,String trainId){
		 ArrayList<HashMap<String,String>> list = new  ArrayList<HashMap<String,String>>();
		 String queryString = null;
		 
		// declaring query phrase
		 if(trainId == null) {
			 queryString = "SELECT * FROM "+this.GetTableName() + " WHERE station_from ='"+stationFrom+"'"; 
		 }else {
			 queryString = "SELECT * FROM "+this.GetTableName() + " WHERE station_from ='"+stationFrom+"' AND train_id = '"+trainId+"'";
		 }
		 
		 try {
			ResultSet result = this.db.statement.executeQuery(queryString);
			
			while(result.next()) {
				// assigning values
				HashMap<String,String> tempData = new HashMap<String,String>();
				tempData.put("station_from", result.getString("station_from"));
				tempData.put("id", result.getString("id"));
				tempData.put("station_to", result.getString("station_to"));
				tempData.put("train_id", result.getString("train_id"));
				tempData.put("time", result.getString("time"));
				tempData.put("status", result.getString("status"));
				tempData.put("fare", result.getString("fare"));
				tempData.put("last_activity", result.getString("last_activity"));
				tempData.put("last_modify_by", result.getString("last_modify_by"));
				tempData.put("total_seat", result.getString("total_seat"));
				tempData.put("seat_range", result.getString("seat_range"));
				tempData.put("type", result.getString("type"));
				list.add(tempData);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
	}
	// get all method for returning property values overloaded
	public ArrayList<HashMap<String,String>> getAll(String stationFrom){
		return this.getAll(stationFrom,null);
	}
	
	@Override
	// save method as object record insertion mediator
	public int Save() {
		int destinationId = 0;
		destinationId = this.InsertNew();
		return destinationId;
		
	}

	@Override
	// basic update method
	public int Update() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// delete method with error handling
	public boolean Delete(String destId) {
		boolean check = false;
		// declaring query phrase
		String querySting = "DELETE FROM "+this.table_name+ " WHERE id='"+destId+"'";

		//error handling
		try {

			rs = this.db.statement.executeUpdate(querySting);
			
			if (rs != 0) {
				check = true;
			} else {
				check = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
		
	}
	
	// update method with error handling
	public boolean Update(String destId) {
		boolean check = false;
		// declaring query phrase
		String sql = "UPDATE "+this.table_name+" SET time= '"+this.time+"',fare= '"+this.fare+"',total_seat= '"+this.total_seat+"',seat_range= '"+this.seat_range+"' WHERE id = '"+destId+"'";

		//error handling
		try {

			rs = this.db.statement.executeUpdate(sql);
			
			if (rs != 0) {
				check = true;
			} else {
				check = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
		}
	
	

	@Override
	// overloaded delete method with error handling
	public void Delete() {
		// declaring query phrase
		String querySting = "DELETE FROM "+this.GetTableName()+ " WHERE id='"+this.id+"'";

		//error handling
		try {
			db.statement.executeUpdate(querySting);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	// getter for table name
	public String GetTableName() {
		// TODO Auto-generated method stub
		return this.table_name;
	}
	
	// insert method encapsulated for security 
	private int InsertNew() {
		int checkBit = 1;
		// declaring query phrase
		String sqlQury = "INSERT INTO "+this.GetTableName()+" (station_from,station_to,train_id,time,status,fare,last_activity,last_modify_by,total_seat,seat_range,type) "
				+ " VALUES('"+this.station_from+"','"+this.station_to+"','"+this.train_id+"','"+time+"','"+status+"','"+fare+"','"+last_activity+"','"+last_modify_by+"','"+total_seat+"','"+seat_range+"','"+type+"')";
		// error handling
		try {
			return this.db.statement.executeUpdate(sqlQury,Statement.NO_GENERATED_KEYS);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			checkBit = 0;
		}
		return checkBit;
	}
}
