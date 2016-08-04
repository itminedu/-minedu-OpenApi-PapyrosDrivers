package gr.mimedu.papyros.protocol.exceptions;

public class SearchException  extends Exception{

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
	public SearchException(){
		super();
	}
	public SearchException(String msg){
		super(msg);
	}
	public SearchException(Integer code, String msg){
		super(msg);
		this.code=code;
		
	}
}