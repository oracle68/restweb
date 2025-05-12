package com.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.MyCompany;

@RestController
public class MyCompanyController {

	@RequestMapping(value="/company", method=RequestMethod.GET)
    public @ResponseBody MyCompany getCompany() {
 
        return new MyCompany(12, "John Greece", "john.greece@test.com");
    }
 
    @RequestMapping(value="/companies", method=RequestMethod.GET)
    public @ResponseBody List<MyCompany> getCompanies() {
 
        List<MyCompany> companies = new ArrayList<MyCompany>();     
        companies.add(new MyCompany(3, "Andrew Strauss", "andrew.strauss@test.com"));       
        companies.add(new MyCompany(12, "John Greece", "john.greece@test.com"));
        companies.add(new MyCompany(101, "Robert Parera", "robert.parera@test.com"));
        companies.add(new MyCompany(153, "Charlotte O' Neil", "charlotte.neil@test.com"));
        companies.add(new MyCompany(239, "Eddy Knight", "eddy.knight@test.com"));
 
        return companies;
    }
}
