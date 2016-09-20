/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.minedu.papyros.protocol.dto;

//import com.wordnik.swagger.annotations.ApiModel;
import java.util.Date;

import gr.minedu.papyros.protocol.dto.DocCategory;
import gr.minedu.papyros.protocol.dto.Sender;


import java.io.Serializable;

/**
 *
 * @author anagnosg
 */

public class Protocolin implements Serializable {

    private Integer senderId; //ID Αποστολέα 
	private String senderProtocol; //Αριθμός Πρωτοκόλλου Αποστολέα
    private String senderProtocolDate;//Ημερομηνία Πρωτοκόλλου Αποστολέα //της μορφής DD/MM/YYYY
	private Integer docCategory;//Κατηγορία Εγγράφου 
    private String theme;//Θέμα
    private String ada; //ΑΔΑ
	private String description; //Συνημμένα Περιγραφή
    private DocumentDto mainDoc; //Main DOC
	private DocumentDto[] attachedDoc; //Συνημμένα Αρχεία Εγγράφων

	
	public Integer getSenderId() {
		return senderId;
	}
	
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public String getSenderProtocolDate() {
		return senderProtocolDate;
	}
	public void setSenderProtocolDate(String senderProtocolDate) {
		this.senderProtocolDate = senderProtocolDate;
	}
	public Integer getDocCategory() {
		return docCategory;
	}
	public void setDocCategory(Integer docCategory) {
		this.docCategory = docCategory;
	}
	public String getAda() {
		return ada;
	}
	public DocumentDto getMainDoc() {
		return mainDoc;
	}
	public void setMainDoc(DocumentDto mainDoc) {
		this.mainDoc = mainDoc;
	}
	public void setSenderProtocol(String senderProtocol) {
		this.senderProtocol = senderProtocol;
	}
	public void setAda(String ada) {
		this.ada = ada;
	}
    public void setSenderProt(String senderProtocol) {
        this.senderProtocol = senderProtocol;
    }
    public String getSenderProtocol() {
        return senderProtocol;
    }
    
    public void setTheme(String theme) {
        this.theme = theme;
    }
    
    public String getTheme() {
        return theme;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public DocumentDto[] getAttachedDoc() {
        return attachedDoc;
    }
    public void setAttachedDoc(DocumentDto[] attachedDoc) {
        this.attachedDoc = attachedDoc;
    }

}
