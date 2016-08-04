/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.minedu.papyros.protocol.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author pkaratzas
 */
public class ErrorReport implements Serializable {

    public int errorCode;
    public int httpStatusCode;
    public String errorMessage;
    public String devMessage;
    public String seeAlso;
    public List<Object> codeError;

    public ErrorReport() {

    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setHttpStatusCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getHttpStatusCode() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public void setSeeAlso(String seeAlso) {
        this.seeAlso = seeAlso;
    }

    public String getSeeAlso() {
        return seeAlso;
    }


}
