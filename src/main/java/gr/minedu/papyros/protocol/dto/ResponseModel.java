package gr.minedu.papyros.protocol.dto;
public class ResponseModel<E> {
	private int code;
	private int httpCode;
	private E data;
	private String message;
	private String detailedMessage; 
	
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetailedMessage() {
		return detailedMessage;
	}
	public void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}


}
