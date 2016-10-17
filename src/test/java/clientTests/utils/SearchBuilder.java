package clientTests.utils;

import java.util.Date;

import gr.minedu.papyros.protocol.dto.DocumentDto;
import gr.minedu.papyros.protocol.dto.Protocolin;
import gr.minedu.papyros.protocol.dto.Search;
import gr.modus.papyros.protocol.utils.DateUtils;

public class SearchBuilder {

	public static Search buildSender(){
		Search s = new Search();
        s.setSenderId(100000009);
		return s;
	}
	
	public static Search buildDocType(){
		Search s = new Search();
        s.setDocType(20); //Αιτήσεις 
		return s;
	}
	
	public static Search buildDocTypeSender(){
		Search s = new Search();
        s.setDocType(20); //Αιτήσεις 
        s.setSenderId(100000009);
		return s;
	}
}
