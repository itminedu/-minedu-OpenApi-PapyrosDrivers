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

    public List<Sender> sender;
    public String senderProtocol;
    public Date protocolDate;
    public List<DocCategory> docCategory;
    public String theme;
    public String ada;
    public String description;


    public void setSender(Sender sender) {
        this.sender = (List<Sender>) sender;
    }

    public List getSender() {
        return (List) sender;
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


    public void setDocCategory(DocCategory docCategory) {
        this.docCategory = (List<DocCategory>) docCategory;
    }

    public List getDocCategory() {
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
