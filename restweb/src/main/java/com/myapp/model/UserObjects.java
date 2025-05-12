package com.myapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user_objects")
public class UserObjects {
	
	@Id
	@Column(name="object_name")
	String objectName;

	@Column(name="object_type")
	String objectType;
	
	@Column(name="last_ddl_time")
	@DateTimeFormat(pattern="dd/MM/YYYY")
	Date lastDdlTime;

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Date getLastDdlTime() {
		return lastDdlTime;
	}

	public void setLastDdlTime(Date lastDdlTime) {
		this.lastDdlTime = lastDdlTime;
	}

	@Override
	public String toString() {
		return "UserObjects [objectName=" + objectName + ", objectType=" + objectType + ", lastDdlTime=" + lastDdlTime
				+ "]";
	}
	
	public void setUserObjects (UserObjects uo)
	{
	 this.objectName =uo.objectName;
	 this.objectType =uo.objectType;
	 this.lastDdlTime =uo.lastDdlTime;
	 //return this;
	}
	
	public UserObjects getUserObjects()
	{
	 return this;
	}	

}
