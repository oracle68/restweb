package com.myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private long userId;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="FIRST_NAME",length=20)
	private String firstName;
	
	@Column(name="GENDER",length=20)
	private String gender;

	@Column(name="LAST_NAME",length=20)
	private String lastName;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="IDCITY")
	private City city;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	//bi-directional many-to-one association to Provincia
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="IDPROVINCIA")
	private Provincia provincia;

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idadr")
    private Adresa adresa;
    public Adresa getAdresa() {
        return adresa;
    }
 
    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    } 


	public Usuario() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}



	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




/*	public Usuario(long userId,  Date fecha, String firstName,  String lastName,String gender,
			City cityBean, Provincia provincia,Adresa adresa) {
		super();
		this.userId = userId;
		this.fecha = fecha;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.city = cityBean;
		this.provincia = provincia;
		this.adresa=adresa;
	}
*/
	
	@Override
	public String toString() {
		return "Usuario [userId=" + userId + ",  fecha=" + fecha + ", firstName=" + firstName
				+ ", gender=" + gender + ", lastName=" + lastName + 
				", cityBean=[" + (city==null ? " " : (city.getId()+" "+city.getNom())) + 
				"]" + 
				//, provincia=[" + (provincia==null ? " " : (provincia.getCodi()+" "+provincia.getNom())) + "]"+
				" adresa=[" + (adresa==null ? " " : (adresa.getId()+ adresa.getNom()))+ "]]";
	}
	
/*	
	public String toString2() {
		return "Usuario [userId=" + userId + ",  fecha=" + fecha + ", firstName=" + firstName
				+ ", gender=" + gender + ", lastName=" + lastName + "]";
	}	
	
   public Usuario setUsuario(Usuario u)
   {
		this.userId = u.getUserId();
		this.fecha = u.getFecha();
		this.firstName = u.getFirstName();
		this.gender = u.getGender();
		this.lastName = u.getLastName();
		this.city = u.getCity();
		this.provincia = u.getProvincia();
		this.adresa = u.getAdresa();
		return this;
   }
	*/
	
}