package gr.minedu.papyros.protocol.dto;

public class Document {
	private String base64;
    
	
	
	public Document(){
    	
    }
	
    public Document(String base64){
    	this.base64= base64;
    }

	
	
	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}
	

}
