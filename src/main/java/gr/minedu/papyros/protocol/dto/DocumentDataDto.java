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
public class DocumentDataDto implements Serializable{

	private String protocolNumber;
    private Date protocolDate;
    private int docType;
    private List<Sender> sender;
    private String senderProtocol;
    private Date senderDateProtocol;
    private List<DocCategory> docCategory;
    private String theme;
    public String getProtocolNumber() {
		return protocolNumber;
	}
	public void setProtocolNumber(String protocolNumber) {
		this.protocolNumber = protocolNumber;
	}
	public Date getProtocolDate() {
		return protocolDate;
	}
	public void setProtocolDate(Date protocolDate) {
		this.protocolDate = protocolDate;
	}
	public int getDocType() {
		return docType;
	}
	public void setDocType(int docType) {
		this.docType = docType;
	}
	public List<Sender> getSender() {
		return sender;
	}
	public void setSender(List<Sender> sender) {
		this.sender = sender;
	}
	public String getSenderProtocol() {
		return senderProtocol;
	}
	public void setSenderProtocol(String senderProtocol) {
		this.senderProtocol = senderProtocol;
	}
	public Date getSenderDateProtocol() {
		return senderDateProtocol;
	}
	public void setSenderDateProtocol(Date senderDateProtocol) {
		this.senderDateProtocol = senderDateProtocol;
	}
	public List<DocCategory> getDocCategory() {
		return docCategory;
	}
	public void setDocCategory(List<DocCategory> docCategory) {
		this.docCategory = docCategory;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getAda() {
		return ada;
	}
	public void setAda(String ada) {
		this.ada = ada;
	}
	public String getAttachedDocsDescr() {
		return attachedDocsDescr;
	}
	public void setAttachedDocsDescr(String attachedDocsDescr) {
		this.attachedDocsDescr = attachedDocsDescr;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public List<String> getAttachedId() {
		return attachedId;
	}
	public void setAttachedId(List<String> attachedId) {
		this.attachedId = attachedId;
	}
	private String ada;
	private String attachedDocsDescr;
	private String director;
	private List<String> attachedId;
    
    
}
