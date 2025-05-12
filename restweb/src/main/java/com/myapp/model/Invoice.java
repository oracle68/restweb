package com.myapp.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="INVOICES")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Invoice implements Serializable{
    

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "STATUS", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REGIST_DATE", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",locale="es",timezone="Europe/Paris")
    private Calendar registDate;
    
    @JoinColumn(name = "FK_CUSTOMER", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Customer customer;
    
    //@OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
    //private Payment payment;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<InvoiceLine> lines;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Calendar getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Calendar registDate) {
		this.registDate = registDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<InvoiceLine> getLines() {
		return lines;
	}

	public void setLines(List<InvoiceLine> lines) {
		this.lines = lines;
	}

    
}