package com.myapp.modelsqlserver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.myapp.model.Pelis;

@Entity
@Table(name="USUARIS")
//@NamedQuery(name="Usuaris.findAll", query="SELECT u FROM Usuaris u")
public class UsuarisMSS {

	

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		@Column(name="ID")
		private long Id;
		
		@Column(name="NAME",length=20)
		private String name;

		@Column(name="AGE")
		private Integer age;

		@Column(name="GENDER",length=6)
		private String gender;

		@Column(name="ADDRESS",length=20)
		private String address;

		@Column(name="EMAIL",length=20)
		private String email;

		public long getId() {
			return Id;
		}

		public void setId(long id) {
			Id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Usuaris [Id=" + Id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address="
					+ address + ", email=" + email + "]";

		}

		public UsuarisMSS() {
    	}

		
		public UsuarisMSS(long id, String name, Integer age, String gender, String address, String email) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.email = email;
	}

	    public UsuarisMSS setUsuarisMSS(UsuarisMSS u)
	    {
			this.Id = u.Id;
			this.name = u.name;
			this.age = u.age;
			this.gender = u.gender;
			this.address = u.address;
			this.email = u.email;
	    	return this;
	    }
		
}
