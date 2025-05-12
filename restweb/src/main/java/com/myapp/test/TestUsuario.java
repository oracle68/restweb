package com.myapp.test;

import java.util.Date;

import com.myapp.model.Adresa;
import com.myapp.model.City;
import com.myapp.model.Provincia;
import com.myapp.model.Usuario;

public class TestUsuario {

	public static void main(String[] args) {

		long userId=1L;
		String city="BCN";
		Date fecha= new Date();
		String firstName="Jane2";
		String lastName="Jane2";
		String gender="female";
		City cityBean = new City();
		cityBean.setId(1L);
		cityBean.setNom("Barna");

		Provincia provincia = new Provincia();
		
		Adresa adresa = new Adresa();
		
		//Usuario us = new  Usuario(userId, city, fecha, firstName, lastName, gender,cityBean, provincia,adresa);
		
	}

}
