package clientTests;

import java.io.File;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.internal.util.Base64;
import org.junit.Test;

import com.google.gson.Gson;

import gr.mimedu.papyros.protocol.DocumentClient;
import gr.mimedu.papyros.protocol.PAuthClient;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.DocumentDto;

public class DocumentNoReturnTest {
	private static final Logger log = Logger.getLogger(DocumentNoReturnTest.class.getName());
	@Test
    public void getPdfNoData() throws Exception {
        log.info("getPdfNoData test");
        DocumentClient obj = new DocumentClient();
        String docHashId = "sss";
        ApiKey apikey = null;
        try {
            PAuthClient pauth = new PAuthClient();
            apikey = pauth.auth("anagnosg", "123456");
            log.info("Apikey:" + new Gson().toJson(apikey));
            DocumentDto doc = obj.getPdf(docHashId, apikey);
            FileUtils.writeByteArrayToFile(new File("c:/test/" + new Date().getTime()+doc.getFileName() + ".pdf"), Base64.decode(doc.getDocument(). getBase64().getBytes()));;
        } catch (Exception e) {
            log.severe(e.getMessage());
        }
    }

}
