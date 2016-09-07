/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.minedu.papyros.protocol.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author pkaratzas
 */
public class Search {

    private int docType;
    private int senderId;
    private Date startDate;
    private Date endDate;

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public void setDocType(int docType) {
        this.docType = docType;
    }

    public int getDocType() {
        return docType;
    }

}
