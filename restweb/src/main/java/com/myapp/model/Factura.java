package com.myapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="Factura")
@Table(name="Factura")

public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="name")
	private String nom;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private String price;}