package com.myapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADRESA")
public class Adresa {

	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="hibernate_sequence")
	 @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", initialValue = 1, allocationSize=1)
	 @Column(name="idadr")
	 private Long id;
	 @Column(name="nom")
	 private String nom;

	/* @OneToOne//(mappedBy="USUARIO")
	 private Usuario usuario;
		public Usuario getUsuario() {
			return usuario;
		}
		public void setUser(Usuario usuario) {
			this.usuario = usuario;
		}
*/
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

	public Adresa(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public Adresa() {
		super();
	}
	@Override
	public String toString() {
		return "Adresa [id=" + id + ", nom=" + nom + "]";
	}
	 
	 
	 
}
