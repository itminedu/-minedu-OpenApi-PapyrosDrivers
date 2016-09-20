/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.minedu.papyros.protocol.dto;

import java.util.Date;
import java.util.List;



import gr.minedu.papyros.protocol.dto.DocCategory;
import gr.minedu.papyros.protocol.dto.Sender;

import java.io.Serializable;

/**
 *
 * @author pkaratzas
 */
public class DocumentDataDto implements Serializable {

	private String id; //HashID
	private Integer protocolNumber; // Αριθμός Πρωτοκόλλου
	private String protocolDate; //Ημερομηνία Πρωτοκόλλου
	private int docType; //Τύπος Εγγράφου (1 Εισερχόμενο, 2 Εξερχόμενο)
    private Integer sender; //ID Αποστολέα 
	private String senderProtocol; //Αριθμός Πρωτοκόλλου Αποστολέα
    private String senderDateProtocol; //Ημερομηνία Πρωτοκόλλου Αποστολέα
    private Integer docCategory;  //Κατηγορία Εγγράφου 
    private String theme; //Θέμα
    private String ada; //ΑΔΑ
    private String attachedDocsDescr; //Συνημμένα Περιγραφή
    private String director; //Δ/νση Παραγωγής
    private String[] attachedId; //Συνημμένα

    public Integer getProtocolNumber() {
		return protocolNumber;
	}

	public void setProtocolNumber(Integer protocolNumber) {
		this.protocolNumber = protocolNumber;
	}
    public String getProtocolDate() {
		return protocolDate;
	}

	public void setProtocolDate(String protocolDate) {
		this.protocolDate = protocolDate;
	}

	public String getSenderDateProtocol() {
		return senderDateProtocol;
	}

	public void setSenderDateProtocol(String senderDateProtocol) {
		this.senderDateProtocol = senderDateProtocol;
	}
	
    public Integer getSender() {
		return sender;
	}

	public void setSender(Integer sender) {
		this.sender = sender;
	}

	public Integer getDocCategory() {
		return docCategory;
	}

	public void setDocCategory(Integer docCategory) {
		this.docCategory = docCategory;
	}
	
    public void setDocType(int docType) {
        this.docType = docType;
    }

    public int getDocType() {
        return docType;
    }

    

    public void setSenderProt(String senderProtocol) {
        this.senderProtocol = senderProtocol;
    }

    public String getSenderProtocol() {
        return senderProtocol;
    }

    

    public String[] getAttachedId() {
        return attachedId;
    }

    public void setAttachedId(String[] attachedId) {
        this.attachedId = attachedId;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

   

    public String getAda() {
        return ada;
    }

    public void setAttachedDocsDescr(String attachedDocsDescr) {
        this.attachedDocsDescr = attachedDocsDescr;
    }

    public String getAttachedDocsDescr() {
        return attachedDocsDescr;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSenderProtocol(String senderProtocol) {
		this.senderProtocol = senderProtocol;
	}

	public void setAda(String ada) {
		this.ada = ada;
	}

}
