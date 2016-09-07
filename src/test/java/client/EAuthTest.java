package client;

import java.util.logging.Logger;

import org.junit.Test;

import com.google.gson.Gson;

import gr.mimedu.papyros.protocol.PAuthClient;
import gr.mimedu.papyros.protocol.exceptions.AuthenticateException;
import gr.minedu.papyros.protocol.dto.ApiKey;

public class EAuthTest {

    private static final Logger log = Logger.getLogger(EAuthTest.class.getName());

    @Test
    public void authWrongUser() throws Exception {
        log.info("authWrongUser test");
        PAuthClient pauth = new PAuthClient();
        try {
            pauth.auth("test", "test2");
        } catch (AuthenticateException e) {
            log.severe(e.getMessage());
        }
    }

    @Test
    public void authWrongPassword() throws Exception {
        log.info("authWrongPassword test");
        PAuthClient pauth = new PAuthClient();
        try {
            pauth.auth("testUsername", "test2");
        } catch (AuthenticateException e) {
            log.severe(e.getMessage());
        }
    }

    @Test
    public void authCorrect() throws Exception {
        log.info("authCorrect test");
        PAuthClient pauth = new PAuthClient();
        try {
            ApiKey apikey = pauth.auth("string", "string");
            log.info("Apikey:" + new Gson().toJson(apikey));
        } catch (AuthenticateException e) {

            log.severe(e.getMessage());
            e.printStackTrace();
        }
    }
}
