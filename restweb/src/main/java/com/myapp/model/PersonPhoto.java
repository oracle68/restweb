package com.myapp.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_photo")
public class PersonPhoto {

	public PersonPhoto() {
	}

	@Id
	@GeneratedValue
	Long id;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="photo")
	Blob photo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public PersonPhoto(Long id, String nom, Blob photo) {
		super();
		this.id = id;
		this.nom = nom;
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "PersonPhoto [id=" + id + ", nom=" + nom + ", photo=" + photo + "]";
	}
	
	
	
	
}
