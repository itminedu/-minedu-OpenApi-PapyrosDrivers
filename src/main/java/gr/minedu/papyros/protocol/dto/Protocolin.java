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

public class Protocolin implements Serializable{

    private Sender[] sender;
    private String senderProtocol;
    private Date protocolDate;
    private DocCategory[] docCategory;
    private String theme;
    private String ada;
    private String description;
    private String document;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
    
    
    public Date getProtocolDate() {
        return protocolDate;
    }

    public void setProtocolDate(Date protocolDate) {
        this.protocolDate = protocolDate;
    }


    public void setSender(Sender[] sender) {
        this.sender = sender;
    }

    public Sender[] getSender() {
        return sender;
    }

    public void setSenderProt(String senderProtocol) {
        this.senderProtocol = senderProtocol;
    }

    public String getSenderProtocol() {
        return senderProtocol;
    }

    public void setDate(Date protocolDate) {
        this.protocolDate = protocolDate;
    }


    public void setDocCategory(DocCategory[] docCategory) {
        this.docCategory = docCategory;
    }

    public DocCategory[] getDocCategory() {
        return docCategory;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    public void setADA(String ada) {
        this.ada = ada;
    }

    public String getAda() {
        return ada;
    }

    public void setDescriptin(String description) {
        this.description = description;
    }

    public String getdescription() {
        return description;
    }

}
