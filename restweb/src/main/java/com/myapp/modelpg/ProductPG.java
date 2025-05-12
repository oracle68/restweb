package com.myapp.modelpg;

import java.io.IOException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.ObjectMapper;


@Entity (name = "Product")
@Table(name="PRODUCT")
public class ProductPG {

	@Id
	@Column(name="ID")
    @GeneratedValue 
	private  Long id;
	 
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRICE")
	private Double price;

	@Column(name="QTY")
	private Integer qty;	

	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "ProductPG [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", qty="
				+ qty + ", fecha=" + fecha + "]";
	}

	public ProductPG(Long id, String name, String description, Double price,Integer qty,Date fecha) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.qty = qty;
		this.fecha = fecha;
	}

	public ProductPG() {

	}
	
    public ProductPG setProductPG(ProductPG u)
    {
		this.id = u.id;
		this.name = u.name;
		this.description = u.description;
		this.price =  u.price;
		this.qty = u.qty;
		this.fecha = u.fecha;
    	return this;
    }
	
	
/*	public String toJson() throws IOException{
		  ObjectMapper Obj = new ObjectMapper(); 
		 
		  return Obj.writeValueAsString(this);

		}

	public Product setProduct(Product product)
	{
		this.id=product.getId();
		this.name=product.getName();
		this.description=product.getDescription();
		this.price = product.getPrice();
		return this;
	}
	
	public Product getProduct()
	{
	 return this;	
		
	}
	*/
}
