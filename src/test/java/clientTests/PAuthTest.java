package clientTests;

import java.util.logging.Logger;

import org.junit.Test;

import com.google.gson.Gson;

import gr.mimedu.papyros.protocol.PAuthClient;
import gr.mimedu.papyros.protocol.exceptions.AuthenticateException;
import gr.minedu.papyros.protocol.dto.ApiKey;

public class PAuthTest {
	private static final Logger log = Logger.getLogger(PAuthTest.class.getName());
	
	@Test
    public void pauthWrongUser() throws Exception {
     	log.info("pauthWrongUser test");
     	PAuthClient pauth = new PAuthClient();
		try {
			pauth.auth("test", "test2");
		} catch (AuthenticateException e) {
			log.severe(e.getMessage());
		}
    }
	
    @Test
    public void pauthWrongPassword() throws Exception {
     	log.info("pauthWrongPass test");
     	PAuthClient pauth = new PAuthClient();
		try {
			pauth.auth("testUsername", "test2");
		} catch (AuthenticateException e) {
			log.severe(e.getMessage());
		}
    }
	
	
	@Test
    public void pauthCorrect() throws Exception {
     	log.info("pauthCorrect test");
     	PAuthClient pauth = new PAuthClient();
		try {
			ApiKey apikey  = pauth.auth("anagnosg", "123456");
			log.info("Apikey:"+new Gson().toJson(apikey));
		} catch (AuthenticateException e) {
			
			log.severe(e.getMessage());
			e.printStackTrace();
		}
    }
	
}
