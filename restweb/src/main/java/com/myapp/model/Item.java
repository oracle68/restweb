package com.myapp.model;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.ObjectMapper;


@Entity (name = "Item")
@Table(name="ITEM")
public class Item implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	
	public Item() {}

	@Id
	@Column(name="ID")
	@GeneratedValue//(strategy = GenerationType.SEQUENCE, generator = "seq_id")
	//@SequenceGenerator(name="seq_id", sequenceName = "seqid")
	 private Long id;
	 
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
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	

	
	public Item(Long id, String name, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}


/*	public String toJson() throws IOException{
		  ObjectMapper Obj = new ObjectMapper(); 
		 
		  return Obj.writeValueAsString(this);

		}
*/	    
	
}
