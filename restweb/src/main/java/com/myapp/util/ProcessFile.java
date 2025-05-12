package com.myapp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFile {

	public static void  main (String[] args) throws IOException
	{
		
		FileReader f = new FileReader(new File("src/main/resources/login_history.txt"));
		//try (FileReader reader = new FileReader(new File("src/main/resources/products.json")))
		BufferedReader b = new BufferedReader(f);
		String cadena = null;
        try
        {
		while((cadena = b.readLine())!=null) {
        
        if (cadena.length()>1 && cadena.contains("@"))
        {	
			StringBuilder s= new StringBuilder(cadena); 
			String s2=s.toString();
			if (s2.contains("https://")) {s=s.delete(0, 8);}
			if (s2.contains("http://"))	 {s=s.delete(0, 7);}
			s=s.delete(s.indexOf("@"), s.length());
			System.out.println(s);
        }	
      }
		
        b.close();
        }catch (Exception ex) {System.out.println(cadena);}	
	}
}
