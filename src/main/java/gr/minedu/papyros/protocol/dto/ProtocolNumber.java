/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.minedu.papyros.protocol.dto;

/**
 *
 * @author pkaratzas
 */
public class ProtocolNumber {

    public int docId;
    public int protocolYear;
    public int protocolNumber;

    public void setDocId(int docId){
        this.docId=docId;
    }
    
    public int getDocId(){
        return docId;
    }
    
    public void setProtocolYear(int protocolYear){
        this.protocolYear=protocolYear;
    }
    
    public int getProtocolYear(){
        return protocolYear;
    } 
    
    public void setProtocolNumber(int protocolNumber){
        this.protocolNumber=protocolNumber;
    }
    
    public int getProtocolNumber(){
        return protocolNumber;
    }
}
