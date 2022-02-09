/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hamar
 */

import java.io.Serializable;

public class Medicine implements Serializable{
    String name;
    int id;
    String description;
    int quantity;
    double price;
    String exp;
    
    public void setExp(String e){
        exp = e;
    }
    
    public String getExp(){
        return exp;
    }
    
    public void setPrice( double p){
        price = p;
    }
    
    public void setName(String n){
        name =n;
    }
    
     public void setdescription(String d){
        description =d;
    }
     
    public void setId(int i){
         id =i;
     }
    
    public int getId(){
        return id;
    }
     
     public String getName(){
         return name;
     }
     
     public String getDescription(){
         return description;
     }
     
     public void setQuantity(int q){
         quantity = q;
     }
     
     public int getQuantity(){
         return quantity;
     }
     
     public double getPrice(){
         return price;
     }
    
}
