package client;

import java.util.logging.Logger;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gr.mimedu.papyros.protocol.DocumentClient;
import gr.mimedu.papyros.protocol.PAuthClient;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.DocumentDataDto;

public class DocumentDataTest {
	private static final Logger log = Logger.getLogger(DocumentDataTest.class.getName());
	
	@Test
    public void getDocumentDataNoData() throws Exception {
     	log.info("getDocumentDataNoData test");
     	DocumentClient obj = new DocumentClient();
		String docHashId = "sss";
     	ApiKey apikey =null;
		try {
     		PAuthClient pauth = new PAuthClient();
			apikey  = pauth.auth("string", "string");
			log.info("Apikey:"+new Gson().toJson(apikey));
			DocumentDataDto docData = obj.getDocumentData(docHashId, apikey)  ;
			log.info("docData:"+new Gson().toJson(docData));
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
    }
	
	@Test
    public void getDocumentData() throws Exception {
     	log.info("getDocumentData test");
     	DocumentClient obj = new DocumentClient();
		String docHashId = "abc12345678";
     	ApiKey apikey =null;
		try {
     		PAuthClient pauth = new PAuthClient();
			apikey  = pauth.auth("string", "string");
			log.info("Apikey:"+new Gson().toJson(apikey));
			DocumentDataDto docData = obj.getDocumentData(docHashId, apikey)  ;
			Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
			log.info("docData:"+new Gson().toJson(docData));
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
    }
}
