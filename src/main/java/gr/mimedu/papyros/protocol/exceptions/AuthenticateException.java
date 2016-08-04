package gr.mimedu.papyros.protocol.exceptions;

public class AuthenticateException extends Exception {
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
	public AuthenticateException(){
		super();
	}
	public AuthenticateException(String msg){
		super(msg);
	}
	public AuthenticateException(Integer code, String msg){
		super(msg);
		this.code=code;
		
	}
}
