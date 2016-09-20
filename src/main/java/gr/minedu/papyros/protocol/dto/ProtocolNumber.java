/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.minedu.papyros.protocol.dto;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author anagnosg
 */
public class ProtocolNumber {

    public String docId;
    public int protocolYear;
    public String protocolNumber;
    public List<DocumentInfo> attachments = new ArrayList<DocumentInfo>();
    
    
   

	public List<DocumentInfo> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<DocumentInfo> attachments) {
		this.attachments = attachments;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	
    public String getProtocolNumber() {
		return protocolNumber;
	}

	public void setProtocolNumber(String protocolNumber) {
		this.protocolNumber = protocolNumber;
	}

	
    
    public void setProtocolYear(int protocolYear){
        this.protocolYear=protocolYear;
    }
    
    public int getProtocolYear(){
        return protocolYear;
    } 
}
