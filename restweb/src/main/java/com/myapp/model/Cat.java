package com.myapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Embeddable
//@Immutable
@Entity
@Table(name="user_catalog")
public class Cat {
	@Id
	@Column(name = "table_name")
	String tableName;
	@Column(name = "table_type")
	String tableType;
	@Override
	public String toString() {
		return "Cat [tableName=" + tableName + ", tableType=" + tableType + "]";
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	public Cat setCat (Cat cat)
	{
	  this.tableName= cat.tableName;
	  this.tableType= cat.tableType;
	  return this;	
	}
	
	
}
