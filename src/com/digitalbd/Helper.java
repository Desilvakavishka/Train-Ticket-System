package com.digitalbd;

import java.util.HashMap;

public class Helper {
	public static final String baseUrl = "http://localhost:8090/Train_Ticket_System/";
	public static final String TestName="John Doe";
	public static final String Currency = "Rs";
	public static HashMap<String,String> TrainsCoach(){
		HashMap<String,String> coach = new HashMap<String,String>();
		coach.put("1-Class", "1-Class");
		coach.put("2-Class", "2-Class");
		coach.put("3-Class", "3-Class");
		return coach;
	}
}
