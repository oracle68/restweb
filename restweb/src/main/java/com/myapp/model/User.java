package com.myapp.model;


import java.io.IOException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.ObjectMapper;


@Entity
@Table(name = "usuarios")
public class User {
//FIRST_NAME	LAST_NAME	GENDER	CITY	USER_ID
    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long user_id;

    @Column(name = "city")
    private String city;

    
	@Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcity")
    private City cityBean;
    public City getCityBean() {
        return cityBean;
    }
 
    public void setCityBean(City cityBean) {
        this.cityBean = cityBean;
    }

    @OneToOne(optional = true,cascade = CascadeType.ALL)
    @JoinColumn(name = "idprovincia")
    private Provincia provincia;
    public Provincia getProvincia() {
        return provincia;
    }
 
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idadr")
    private Adresa adresa;
    public Adresa getAdresa() {
        return adresa;
    }
 
    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    } 
    
    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
    public Long getId() {
        return user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }    
   


	public User(Long user_id, String city,String firstName, String lastName, String gender,City cityBean, 
			  Provincia provincia,Adresa adresa) {
		super();
		this.user_id = user_id;
		this.city = city;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.cityBean = cityBean;
		this.provincia = provincia;
		this.adresa=adresa;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id +" , city=" + city+ ", firstName=" + firstName + ", lastName=" + lastName + ",  gender=" + gender +  
				 " , cityBean =[" + toS()+"]"+
				 ", provincia =[" + toProv() + "] " +
				 ",adresa =[ "+ toAdr()+ "]]";
	}
    
	public String toS()
	{  
		String res;
		try {
		if (cityBean.getId()==0L)
			res ="vacio,vacio";
		else res=cityBean.getId()+","+cityBean.getNom();
		return res;
		}
		catch (Exception e) {return ("vacio,vacio");}
		
	}

	public String toProv()
	{  
		String res;
		try {
		if (provincia.getNom().equals(""))
			res ="vacio,vacio";
		else res=adresa.getId()+","+provincia.getNom();
		return res;
		}
		catch (Exception e) {return ("vacio,vacio");}
		
	}	
	
	public String toAdr()
	{  
		String res;
		try {
		if (adresa.getId()==0L)
			res ="vacio,vacio";
		else res=adresa.getId()+","+adresa.getNom();
		return res;
		}
		catch (Exception e) {return ("vacio,vacio");}
		
	}	
	public String toString2() {
		return "User [user_id=" + user_id +" , city=" + city+ ", firstName=" + firstName + ", lastName=" + lastName + ",  gender=" + gender +  
				 " , cityBean =[" + cityBean.getId() +" " + cityBean.getNom()+"]"+
				 ", provincia =[" + provincia.getNom()+" " + cityBean.getNom() + "] " +
				 "]";
	}
	public User() {
		super();
	}
	
	   public User setUser(User u)
	   {
			this.user_id = u.getId();
			this.city = u.getCity();
			//this.fecha = u.getFecha();
			this.firstName = u.getFirstName();
			this.gender = u.getGender();
			this.lastName = u.getLastName();
			this.cityBean = u.getCityBean();
			this.provincia = u.getProvincia();
			this.adresa = u.getAdresa();
			return this;
	   }
			

	public String toJson() throws IOException{
		  ObjectMapper Obj = new ObjectMapper(); 
		 
		  return Obj.writeValueAsString(this);

		}
      
}