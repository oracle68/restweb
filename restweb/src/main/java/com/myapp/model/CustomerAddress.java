package com.myapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="CustomerAddress")
public class CustomerAddress implements Serializable {
	 
		private static final long serialVersionUID = -5734276483633457611L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	Long id;

	@Column(name = "name")
	String name;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "country")
	String country;
	
	@Column(name = "adreca")
	String adreca;
	
	@Column(name = "zipcode")
	String zipcode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return adreca;
	}

	public void setAddress(String adreca) {
		this.adreca = adreca;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public CustomerAddress(Long id, String name, String password, String country, String adreca, String zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.country = country;
		this.adreca = adreca;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "CustomerAddress [id=" + id + ", name=" + name + ", password=" + password + ", country=" + country
				+ ", adcreca=" + adreca + ", zipcode=" + zipcode + "]";
	}

	public CustomerAddress() {
		super();

	}
	
	
	public CustomerAddress setCustomerAddress(CustomerAddress ca)
	{
		this.id = ca.id;
		this.name = ca.name;
		this.password = ca.password;
		this.country = ca.country;
		this.adreca = ca.adreca;
		this.zipcode = ca.zipcode;		
		return this;
	}
	
	
	
	
}
