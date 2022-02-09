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
public class Pid {
    Medicine medicine;
    String userName;
    int pharmid;
    int orderid;
    
    public Pid (Medicine m, String u, int pi, int oi){
        medicine= m;
        userName = u;
        pharmid = pi;
        orderid = oi;
    }
    
    public Medicine getMedicine(){
        return medicine;
    }
    
    public String getUsername(){
        return userName;
    }
    
    public int getPid(){
        return pharmid;
    }
    
    public int getOid(){
        return orderid;
    }
}
