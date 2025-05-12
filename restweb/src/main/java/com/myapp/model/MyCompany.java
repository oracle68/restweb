package com.myapp.model;

import org.springframework.stereotype.Component;

@Component
public class MyCompany {
 
    private int id;
    private String fullname;
    private String email;
 
    public MyCompany() { }
 
    public MyCompany(int id, String fullname, String email) {       
        this.id = id;
        this.fullname = fullname;
        this.email = email;
    }
 
    public int getId() {
        return id;
    }
 
    public String getFullname() {
        return fullname;
    }
 
    public String getEmail() {
        return email;
    }
}	
