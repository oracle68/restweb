package com.myapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the PROVINCIA database table.
 * 
 */
@Entity
//@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
@Table(name="Provincia")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="idProvincia")
	private String idProvincia;
	@Column(name="nom")
	private String nom;

/*	//bi-directional many-to-one association to Usuario
	@OneToOne(mappedBy="provincia")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
*/

	public Provincia() {
	}


	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Provincia(String idProvincia, String nom) {
		super();
		this.idProvincia = idProvincia;
		this.nom = nom;
	}



	/*public Provincia setProvincia(Provincia p) {
		this.idProvincia = p.idProvincia;
		this.nom = p.nom;
		//this.usuario = p.usuario;
		return this;
	}
	*/

}