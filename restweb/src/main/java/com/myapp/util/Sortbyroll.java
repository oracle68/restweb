package com.myapp.util;

import java.util.Comparator;

import com.myapp.model.Product;

class Sortbyroll implements Comparator<Product> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Product a, Product b) 
    { 
        return (int) (a.getName().compareTo( b.getName())); 
    } 
} 
