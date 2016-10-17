package clientTests.utils;

import java.util.Base64;

import gr.minedu.papyros.protocol.dto.Document;
import gr.minedu.papyros.protocol.dto.DocumentDto;

public class DocumentDtoBuilder {

	
	public static DocumentDto build(){
		DocumentDto dto = new DocumentDto();
		dto.setDescription("Δοκιμαστικό");
		dto.setFileName("test.txt");
		dto.setDocument(new Document(Base64.getEncoder ().encodeToString("Είναι ένα δοκιμαστικό κείμενο".getBytes())));
		return dto;
	}
	
	public static DocumentDto buildMain(){
		DocumentDto dto = new DocumentDto();
		dto.setDescription("Δοκιμαστικό Κυριως");
		dto.setFileName("test_main.txt");
		dto.setDocument(new Document(Base64.getEncoder ().encodeToString("Είναι ένα δοκιμαστικό κείμενο MIAN".getBytes())));
		return dto;
	}
}
