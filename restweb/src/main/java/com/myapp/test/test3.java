package com.myapp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test3 {

	public test3() {};
	
	public static void main (String[] args) throws JsonProcessingException
	{
	   List<String> ls = new ArrayList<>(); 	
	   Map <String,List<String>> hm2 = new HashMap();	
	   Map <String,List<String>> hm3 = new HashMap();
	   Map <String,Object> hm = new HashMap();
	   ls.add("1234");
	   ls.add("4567");
	   hm2.put("el repartidor",ls);
	   hm3.put("la compañia",null);
	   hm.put("REP",hm2);
	   hm.put("CIA",hm3);
	   System.out.println(hm.get("REP"));
	   System.out.println(hm.get("CIA"));
	   ObjectMapper mapper = new ObjectMapper();
	   String jsonstr = mapper.writeValueAsString(hm); 
	   System.out.println(jsonstr);
	   
	}

}
