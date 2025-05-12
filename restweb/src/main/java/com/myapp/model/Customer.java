package com.myapp.model;

import java.io.IOException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.map.ObjectMapper;



@Entity
@Table(name="customer")
public class Customer {
 @Id
 @GeneratedValue
 private Long id;
 @Column(name="firstname")
 private String firstname;
 @Column(name="lastname")
 private String lastname;
 @Column(name="password")
 private String password;
 
	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="customer")
	private List<Address> addresses;

	public Customer() {
	}
	
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
			+ "]";
}

public Customer(Long id, String firstname, String lastname, String password, List<Address> addresses) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.password = password;
	this.addresses = addresses;
}
 
public Customer setCustomer(Customer c) {

	this.id = c.id;
	this.firstname = c.firstname;
	this.lastname = c.lastname;
	this.password = c.password;
	this.addresses = c.addresses;
	return this;
}

public String toJson() throws IOException{
	  ObjectMapper Obj = new ObjectMapper(); 
	 
	  return Obj.writeValueAsString(this);

	}
 
}