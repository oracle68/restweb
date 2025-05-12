package com.myapp.model;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.ObjectMapper;





@Entity
@Table(name="address")
public class Address {
 @Id
 @GeneratedValue
 private Long id;

//bi-directional many-to-one association to Customer
@ManyToOne
@JoinColumn(name="FK_CUSTOMER")
private Customer customer;


 @Column(name="country")
 private String country;
 @Column(name="adreca")
 private String adreca;
 @Column(name="zipcode")
 private String zipCode;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
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
public void setAddress(String addreca) {
	this.adreca = addreca;
}
public String getZipCode() {
	return zipCode;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
@Override
public String toString() {
	return "Address [id=" + id + ", customer=" + customer + ", country=" + country + ", adreca=" + adreca
			+ ", zipCode=" + zipCode + "]";
}
 
public Address() {
}
public Address(Long id, Customer customer, String country, String adreca, String zipCode) {
	super();
	this.id = id;
	this.customer = customer;
	this.country = country;
	this.adreca = adreca;
	this.zipCode = zipCode;
}

public Address setAddress(Address a)
{
	this.id = a.id;
	this.customer = a.customer;
	this.country = a.country;
	this.adreca = a.adreca;
	this.zipCode = a.zipCode;
	return this;
}
public String toJson() throws IOException{
  ObjectMapper Obj = new ObjectMapper(); 
 
  return Obj.writeValueAsString(this);

}
 
}
