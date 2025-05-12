package com.myapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.myapp.model.Adresa;
import com.myapp.model.City;
import com.myapp.model.Provincia;
import com.myapp.model.User;

public interface UserDao {

	 public User getById(Long Id);
	 public void add(String nom,String cognom);
	 public User add(User user);
	 public User update(User user);
	 public void delete(Long Id);	 
	 public List<User> findAll();
	 static List<User> getAll() {
           List<User> userlist = new ArrayList<User>();
            Long id = 1L;
            City city = new City (id,"Barcelona");
            Provincia p =  new Provincia("08","Barcelona");
            Adresa adr = new Adresa(2L,"carrer Barcelona");
            
			userlist.add( new User (1L,"Barcelona","John", "Smith","Female", city,p,adr));

			userlist.add( new User (2L,"Barcelona","Helena", "Garcia","Female", city,p,adr));

			userlist.add( new User (3L,"Barcelona","James", "Garcia","Female", city,p,adr));

			userlist.add( new User (4L,"Barcelona","Josh", "Josh", "Female",  city,p,adr));
			userlist.add( new User (5L,"Barcelona","Amber", "Smith","Female", city,p,adr));

			userlist.add( new User (6L,"Barcelona","Destiny", "Garcia","Female",  city,p,adr));	

			userlist.add( new User (7L,"Barcelona","Jon", "Jon","Female",  city,p,adr));
		 return userlist; 
	}
	 default User save2 (User user) {
		 return new User();
	 } 
	 public User getByName(String name);	 
}
