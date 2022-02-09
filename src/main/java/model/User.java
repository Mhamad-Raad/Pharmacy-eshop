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
public class User {
    private String name;
    private String gender;
    private String email;
    private String password;
    private String type;
    private String city;
    private String address;
    private int id;
    
    
    public User(){
        
    }
    
    public void setId(int i){
        id =i;
    }
    
    
    public void setName(String n){
        name = n;
    }
    
    public void setGender(String g){
        gender = g;
    }
    
    public void setEmail(String e){
        email = e;
    }
    
    public void setPassword(String p){
        password = p;
    }
    
    public void setType(String t){
        type = t;
    }
    
    public void setCity(String c){
        city = c;
    }
    
    public void setAddress(String a){
        address = a;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getGender(){
        return gender;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getType(){
        return type;
    }
    
    public String getCity(){
        return city;
    }
    
    public String getAddress(){
        return address;
    }
    
    
}
