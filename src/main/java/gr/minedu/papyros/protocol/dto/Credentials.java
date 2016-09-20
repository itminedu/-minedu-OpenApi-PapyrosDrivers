package gr.minedu.papyros.protocol.dto;



import com.google.gson.Gson;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pkaratzas
 */
public class Credentials  {
    
    private String username;
    private String password;
    
    
    public Credentials(){
        
    }
    
    public Credentials(String json){
    	
    }

    public void setUsername(String username){
        this.username=username;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getPassword(){
        return password;
    }

	
    
    
}

