package com.digitalbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import AllLayout.Station;
import AllLayout.Train;

public class trains {
	public String name,id,code,type="Shuvon",total_seat="";
	public int totalSeat;
	private int rs;
	String table = "trains";
	Database db;
	public trains(){
		this.total_seat=this.name=this.id=this.code = "";
		db = new Database();
		this.totalSeat = 0;
	}
	public String getTrainName(String trainId) {
		String nameTemp = null;
		String sqlQuery = "SELECT * FROM "+this.table+" WHERE id='"+trainId+"'";
		ResultSet result;
		try {
			result = this.db.statement.executeQuery(sqlQuery);
			while(result.next()) {
				nameTemp = result.getString("name").toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nameTemp;
	}
		
	public trains(String trnId) {
		db = new Database();
		String sql = "SELECT * FROM "+this.table+" WHERE id='"+trnId+"'";
		try {
			ResultSet result = this.db.statement.executeQuery(sql);
			while(result.next()) {
				this.name = result.getString("name");
				this.id = result.getString("id");
				this.type = result.getString("type");
				this.code = result.getString("code");
				this.total_seat = result.getString("total_seat");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Train> getAll() {
		ArrayList<Train> trains = new ArrayList<Train>();
		String sqlQuery = "SELECT * FROM " + this.table;
		try {
			ResultSet result = db.statement.executeQuery(sqlQuery);
			while(result.next()) {
				Train temp = new Train();
				temp.id = result.getString("id");
				temp.name = result.getString("name");
				temp.code = result.getString("code");
				temp.type = result.getString("type");
				temp.totalSeat = Integer.parseInt(result.getString("total_seat"));
				trains.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trains;
	}
	public boolean Save() {
		boolean check = false;
		if(this.id.equals("")) {
			check =this.CreateNew();
		}else {
			check = this.CreateNew();
		}
		return check;
		
	}
	public boolean Delete (String trnId) {
		boolean check = false;
		String sql = "DELETE FROM "+this.table+" WHERE id = '"+trnId+"'";
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
	
	/*Search Destinations trains*/
	
	public ArrayList<HashMap<String,String>> SearchTrainFromTo(String from,String to,String coach){
		ArrayList<HashMap<String,String>> trains = new ArrayList<HashMap<String,String>>();
		String sql = null;
		if(coach != null && !coach.equals("any")) {
			 sql = "SELECT destinations.*,trains.type as coach,trains.id as trainId,trains.name,trains.code,trains.type FROM trains"
					+ " INNER JOIN destinations ON "
					+ " trains.id = destinations.train_id"
					+ " WHERE destinations.station_from = '"+from+"'"
					+ " AND destinations.station_to = '"+to+"'"
					+ " AND trains.type = '"+coach+"'"
					+ " ORDER BY name ASC";
		}else {
			 sql = "SELECT destinations.*,trains.type as coach,trains.id as trainId,trains.name,trains.code,trains.type FROM trains"
					+ " INNER JOIN destinations ON "
					+ " trains.id = destinations.train_id"
					+ " WHERE destinations.station_from = '"+from+"'"
					+ " AND destinations.station_to = '"+to+"'"
					+ " ORDER BY name ASC";
		}
		
		try {
			ResultSet result = this.db.statement.executeQuery(sql);
			while(result.next()) {
				HashMap<String,String> tempTrain = new HashMap<String,String>();
				tempTrain.put("name", result.getString("name"));
				tempTrain.put("destination_id", result.getString("id"));
				tempTrain.put("coach", result.getString("coach"));
				tempTrain.put("train_id", result.getString("trainId"));
				tempTrain.put("code", result.getString("code"));
				tempTrain.put("time", result.getString("time"));
				tempTrain.put("code", result.getString("code"));
				tempTrain.put("fare", result.getString("fare"));
				trains.add(tempTrain);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trains;
	}
	
	private boolean CreateNew() {
		boolean check = false;
		String sqlQquery = "";
		sqlQquery = "INSERT INTO "+this.table+"(name,code,total_seat,type)"
				+ " VALUES('"+this.name+"','"+this.code+"','"+Integer.toString(this.totalSeat)+"','"+this.type+"')";
					
		try {
			rs =   this.db.statement.executeUpdate(sqlQquery);
			
			if (rs != 0) {
				check = true;
			} else {
				check = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean Update(String trnId) {
		boolean check = false;
		String sql = "UPDATE "+this.table+" SET name='"+this.name+"',code='"+this.code+"',total_seat='"+Integer.toString(this.totalSeat)+"',type= '"+this.type+"' WHERE id = '"+trnId+"'";

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
}