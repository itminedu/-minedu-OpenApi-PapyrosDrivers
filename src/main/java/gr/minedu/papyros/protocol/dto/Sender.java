/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.minedu.papyros.protocol.dto;

import java.io.Serializable;

/**
 *
 * @author pkaratzas
 */

public class Sender implements Serializable{
    
    public int id;
    public String senderName;
    
    
    public Sender(){
        this.id=id;
        this.senderName=senderName;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setSenderName(String senderName){
        this.senderName=senderName;
    }
    
    public String getSenderName(){
        return senderName;
    }
}
