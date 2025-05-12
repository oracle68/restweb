package com.myapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="Pelis")
public class Pelis {

	public Pelis() {
	}
    @Id
    @GeneratedValue //(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    //@SequenceGenerator(name="seq_id", sequenceName = "seqid")
	Long id;
    
    @Column(name="NOM")
    String nom;
    @Column(name="DESCRIPCIO")
    String descripcio;
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
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public Pelis(Long id, String nom, String descripcio) {
		super();
		this.id = id;
		this.nom = nom;
		this.descripcio = descripcio;
	}
	@Override
	public String toString() {
		return "Pelis [id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + "]";
	}
    
    public Pelis setPelis(Pelis p)
    {
		this.id = p.id;
		this.nom = p.nom;
		this.descripcio = p.descripcio;
    	return this;
    }
    
    
}
