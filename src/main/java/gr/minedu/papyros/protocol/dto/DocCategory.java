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

public class DocCategory implements Serializable{

    public int id;
    public String category;

    public DocCategory() {
        this.id = id;
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setcategory(String senderName) {
        this.category = category;
    }

    public String getSenderName() {
        return category;
    }

}
