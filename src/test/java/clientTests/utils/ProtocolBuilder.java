package clientTests.utils;

import java.util.Date;

import gr.minedu.papyros.protocol.dto.DocCategory;
import gr.minedu.papyros.protocol.dto.DocumentDto;
import gr.minedu.papyros.protocol.dto.Protocolin;
import gr.modus.papyros.protocol.utils.DateUtils;

public class ProtocolBuilder {

	public static Protocolin build(){
		Protocolin protIn = new Protocolin();
		protIn.setSenderId(100000009);
		protIn.setSenderProtocol(""+new Date().getTime());
		protIn.setSenderProtocolDate( new DateUtils().formatDate(new Date()));
		protIn.setDocCategory(20);
		protIn.setTheme("Είναι το θέμα ");
		protIn.setAda("ADA1234567890");
		protIn.setDescription("Δοκιμαστικό Πρώτοκολό "); //Περιγραφή συννημέννων . 
		DocumentDto mainDoc = DocumentDtoBuilder.buildMain();
		protIn.setMainDoc(mainDoc);
		DocumentDto attachDoc = DocumentDtoBuilder.build();
		DocumentDto[] attachements = new DocumentDto[1];
		attachements[0] = attachDoc;
		protIn.setAttachedDoc(attachements);
		
		return protIn;
	}
}
