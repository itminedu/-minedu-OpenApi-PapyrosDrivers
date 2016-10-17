package clientTests;

import java.util.Arrays;
import java.util.logging.Logger;

import org.junit.Test;

import com.google.gson.Gson;

import clientTests.utils.DocumentDtoBuilder;
import clientTests.utils.ProtocolBuilder;
import gr.mimedu.papyros.protocol.PAuthClient;
import gr.mimedu.papyros.protocol.ProtocolSubmitClient;
import gr.mimedu.papyros.protocol.exceptions.AuthenticateException;
import gr.mimedu.papyros.protocol.utils.GsonUtils;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.DocCategory;
import gr.minedu.papyros.protocol.dto.DocumentDto;
import gr.minedu.papyros.protocol.dto.ProtocolNumber;
import gr.minedu.papyros.protocol.dto.Protocolin;

public class ProtocolSubmitClientTest {
private static final Logger log = Logger.getLogger(PAuthTest.class.getName());
	
	@Test
    public void submitProtocol() throws Exception {
     	log.info("submitProtocol");
     	PAuthClient pauth = new PAuthClient();
		try {
			Protocolin prot = ProtocolBuilder.build();
			log.info("prot:"+new Gson().toJson(prot));
			ApiKey apiKey = pauth.auth("anagnosg", "123456");
			ProtocolSubmitClient protClient = new ProtocolSubmitClient();
			ProtocolNumber protocoled = protClient.submitProtocol(prot, apiKey);
			log.info("protocoled:"+GsonUtils.build().toJson(protocoled));
		} catch (AuthenticateException e) {
			log.severe(e.getMessage());
		}
    }
}
