package com.myapp.model;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.map.ObjectMapper;


@Entity (name = "Products")
@Table(name="products")
public class Product {

	@Id
	@Column(name="ID")
    @GeneratedValue //(strategy = GenerationType.SEQUENCE, generator = "seq_id")
	public
    //@SequenceGenerator(name="seq_id", sequenceName = "seqid")
 Long id;
	 
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRICE")
	private Double price;

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
		return "Products [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}

	public Product(Long id, String name, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Product() {
		super();
	}
	
	public String toJson() throws IOException{
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
}
