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
public class Cid {
     Medicine medicine;
    String status;
    int userid;
    int orderid;
    
    
    public Cid (Medicine m, String s, int ui, int oi){
        medicine= m;
        status = s;
        userid = ui;
        orderid = oi;
    }
    
    public Medicine getMedicine(){
        return medicine;
    }
    
    public String getStatus(){
        return status;
    }
    
    public int getuserid(){
        return userid;
    }
    
    public int getOid(){
        return orderid;
    }
    
}
