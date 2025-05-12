package com.myapp.test;

import com.github.javafaker.Faker;

public class TestFaker {

	public static void main(String[] args)
	{
		
		Faker faker = new Faker();
		 
		String streetName = faker.address().streetName();
		String number = faker.address().buildingNumber();
		String city = faker.address().city();
		String country = faker.address().country();
		String fn = faker.name().firstName();
		String ln = faker.name().lastName();
		String un = faker.name().username();
		
		System.out.println(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s",
		  number,
		  streetName,
		  city,
		  country,fn,ln,un));		
	}
}
