package client;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.internal.util.Base64;
import org.junit.Test;

import com.google.gson.Gson;

import gr.mimedu.papyros.protocol.DocumentClient;
import gr.mimedu.papyros.protocol.PAuthClient;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.Document;

public class DocumentTest {

    private static final Logger log = Logger.getLogger(DocumentTest.class.getName());

    @Test
    public void getPdfNoData() throws Exception {
        log.info("getPdfNoData test");
        DocumentClient obj = new DocumentClient();
        String docHashId = "sss";
        ApiKey apikey = null;
        try {
            PAuthClient pauth = new PAuthClient();
            apikey = pauth.auth("string", "string");
            log.info("Apikey:" + new Gson().toJson(apikey));
            Document doc = obj.getPdf(docHashId, apikey);
            FileUtils.writeByteArrayToFile(new File("c:/test/" + new Date().getTime() + ".pdf"), Base64.decode(doc.getBase64().getBytes()));;
        } catch (Exception e) {
            log.severe(e.getMessage());
        }
    }

    @Test
    public void getPdfData() throws Exception {
        log.info("getPdfData test");
        DocumentClient obj = new DocumentClient();
        String docHashId = "abc12345678";
        ApiKey apikey = null;
        try {
            PAuthClient pauth = new PAuthClient();
            apikey = pauth.auth("string", "string");
            log.info("Apikey:" + new Gson().toJson(apikey));
            Document doc = obj.getPdf(docHashId, apikey);
            FileUtils.writeByteArrayToFile(new File("c:/test/" + new Date().getTime() + ".pdf"), Base64.decode(doc.getBase64().getBytes()));;
        } catch (Exception e) {
            log.severe(e.getMessage());
        }
    }

}
