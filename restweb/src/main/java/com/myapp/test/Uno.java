package com.myapp.test;

import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Uno {

		  public String name;
		  public Dos dos;

		  public static void main(String[] args) throws Exception
		  {
		    // JSON input: {"name":"FOO","bar":{"id":42}}
		    String jsonInput = "{\"name\":\"UNO\",\"dos\":{\"id\":42}}";

		    ObjectMapper jsonMapper = new ObjectMapper();
		    Uno uno = jsonMapper.readValue(jsonInput, Uno.class);

		    XmlMapper xmlMapper = new XmlMapper();
		    System.out.println(xmlMapper.writeValueAsString(uno));
		    // <Uno xmlns=""><name>UNO</name><dos><id>42</id></dos></Uno>
		  }

}
