package clientTests;

import java.util.logging.Logger;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import clientTests.utils.ProtocolBuilder;
import gr.mimedu.papyros.protocol.DocumentClient;
import gr.mimedu.papyros.protocol.PAuthClient;
import gr.mimedu.papyros.protocol.ProtocolSubmitClient;
import gr.mimedu.papyros.protocol.utils.GsonUtils;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.DocumentDataDto;
import gr.minedu.papyros.protocol.dto.ProtocolNumber;
import gr.minedu.papyros.protocol.dto.Protocolin;

public class DocumentDataTest {
	private static final Logger log = Logger.getLogger(DocumentDataTest.class.getName());
	
	/**
	 * 
	 * @throws Exception
	 */

    
	
	
    @Test
    public void protocolGetData() throws Exception {
		Gson gson=  GsonUtils.build();
		log.info("protocolGetData test");
     	DocumentClient obj = new DocumentClient();
     	ApiKey apikey =null;
		try {
     		PAuthClient pauth = new PAuthClient();
			apikey  = pauth.auth("anagnosg", "123456");
			log.info("Apikey:"+gson.toJson(apikey));
			Protocolin prot = ProtocolBuilder.build();
			ProtocolSubmitClient protClient = new ProtocolSubmitClient();
			ProtocolNumber protocoled = protClient.submitProtocol(prot, apikey);
			log.info("protocoled:"+gson.toJson(protocoled));
			
			DocumentDataDto docData = obj.getDocumentData(protocoled.getDocId(), apikey)  ;
			
			log.info("docData:"+gson.toJson(docData));
		} catch (Exception e) {
			e.printStackTrace();
			log.severe(e.getMessage());
		}
    }
}
