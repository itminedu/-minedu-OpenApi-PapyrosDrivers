package clientTests;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.internal.util.Base64;
import org.junit.Test;

import com.google.gson.Gson;

import clientTests.utils.SearchBuilder;
import gr.mimedu.papyros.protocol.DocumentClient;
import gr.mimedu.papyros.protocol.PAuthClient;
import gr.mimedu.papyros.protocol.SearchClient;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.Document;
import gr.minedu.papyros.protocol.dto.DocumentDto;
import gr.minedu.papyros.protocol.dto.Search;

public class DocumentTest {

    private static final Logger log = Logger.getLogger(DocumentTest.class.getName());

    
    @Test
    public void getPdfData() throws Exception {
        log.info("getPdfData test");
        DocumentClient obj = new DocumentClient();
       
        ApiKey apikey = null;
        try {
            PAuthClient pauth = new PAuthClient();
            apikey = pauth.auth("anagnosg", "123456");
            log.info("Apikey:" + new Gson().toJson(apikey));
            Search searchCriteria = SearchBuilder.buildSender();
            SearchClient search = new SearchClient();
            List<String> docHashIds = search.search(searchCriteria, apikey);
            log.info(new Gson().toJson(docHashIds));
            
            for(int i = 0 ; i < docHashIds .size() ;i++){
            	String docHashId = docHashIds.get(i);
            	DocumentDto doc = obj.getPdf(docHashId, apikey);
            	log.info(new Gson().toJson(doc));
            	if(doc!=null){
            		FileUtils.writeByteArrayToFile(new File("c:/test/" +   new Date().getTime()+doc.getFileName() + ".pdf"), Base64.decode(doc.getDocument(). getBase64().getBytes()));
            	}
            	else{
            		log.info("Doc is null docHashId:"+docHashId);
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
