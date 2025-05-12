package com.myapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CITY database table.
 * 
 */
@Entity
//@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
@Table(name="CITY")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="hibernate_sequence")
	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", initialValue = 1, allocationSize=1)
	@Column(name="idcity")
	private long id;
   
	@Column(name="nom")
	private String nom;

	//@OneToOne (mappedBy="city")
	//private Usuario usuario;

	public City() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public City(long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", nom=" + nom + "]"; //, usuario=" + usuario + "]";
	}
	
	
	

}