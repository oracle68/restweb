package com.myapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.myapp.model.Adresa;
import com.myapp.model.City;
import com.myapp.model.Provincia;
import com.myapp.model.User;


public class UserDaoImpl implements UserDao{
	final static Logger log = Logger.getLogger(UserDaoImpl.class); 	
	List<User> userlist = new ArrayList<User>(); 
	Long id;
	
	public UserDaoImpl() {
		super();
		init();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public User getById(Long Id)
	{

	    Iterator<User> iterator = findAll().iterator();
	    while (iterator.hasNext()) {
	        User user = iterator.next();
	        if (user.getId()==Id) {
	            return user;
	        }
	        }
	    return null;
	}		

	public User getByName(String name)
	{

	    Iterator<User> iterator = findAll().iterator();
	    while (iterator.hasNext()) {
	        User user = iterator.next();
	        if (user.getFirstName().equals(name)) {
	            return user;
	        }
	    }
	    return null;
	}		
	
	public void add(String nom,String cognom)
	{
		
		log.debug("**************id:"+id);
		id++;
		log.debug("**************id:"+id);
		userlist.add( new User (id,"Barcelona",nom, cognom, "Male",new City (id,"Barcelona"),
				      new Provincia("08","Barcelona"),new Adresa(2L,"carrer Barcelona")));
		log.debug("********End");
	}

	public User save(User user)
	{
		return 
				new User (id,"Barcelona","Jenifer", "Sants","Female", new City (id,"Barcelona"),
						 new Provincia("08","Barcelona"),
						 new Adresa(id,"Carrer de Barcelona"));
	}

	
	public List<User> findAll()
	{

		return userlist;
	}
	
	public void init()
	{
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

	}

	public static List<User> getAll()
	{
		//UserDaoImpl ud = new UserDaoImpl();  
		return UserDao.getAll();
	}

	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long Id) {
		// TODO Auto-generated method stub
		
	}
	

}
