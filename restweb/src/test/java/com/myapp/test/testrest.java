package com.myapp.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class testrest {

    @Test

    public void testresponse() throws Exception {
    	String url= "http://localhost:8180/restweb/rest/prueba/87";	
    	String respuesta="My Jersey application says : 87";
    	   // Given
        HttpUriRequest request = new HttpGet(url );
     
        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        System.out.println(httpResponse.toString());
        System.out.println(httpResponse.getStatusLine().toString());
        BufferedReader rd = new BufferedReader(
        		new InputStreamReader(httpResponse.getEntity().getContent()));

        	StringBuffer result = new StringBuffer();
        	String line = "";
        	while ((line = rd.readLine()) != null) {
        		result.append(line);
        	}
        	System.out.println(result);
        // Then
        assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
        assertEquals(result.toString(),respuesta);

    }
	
}
