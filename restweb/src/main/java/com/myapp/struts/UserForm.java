package com.myapp.struts;

public class UserForm extends org.apache.struts.action.ActionForm {

	 private String firstname;
     private String lastname;
     private String gender;
     private String city;
     private String valor;
     private String error;
     
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getError() {
		return error;
	}
    public void setError(String error) {
   	 this.error = "<div style='color:red'>"+error+"</div>";
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
	}
     

}