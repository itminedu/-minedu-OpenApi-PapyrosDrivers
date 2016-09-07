/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.mimedu.papyros.protocol.exceptions;

/**
 *
 * @author pkaratzas
 */
public class ProtocolException extends Exception{
    
    int code;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ProtocolException() {
        super();
    }

    public ProtocolException(String msg) {
        super(msg);
    }

    public ProtocolException(Integer code, String msg) {
        super(msg);
        this.code = code;

    }
    
}
