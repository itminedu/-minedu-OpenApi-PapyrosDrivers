package clientTests;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import com.google.gson.Gson;

import clientTests.utils.SearchBuilder;
import gr.mimedu.papyros.protocol.PAuthClient;
import gr.mimedu.papyros.protocol.SearchClient;
import gr.mimedu.papyros.protocol.exceptions.AuthenticateException;
import gr.mimedu.papyros.protocol.exceptions.SearchException;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.Search;

public class SearchTest {

    private static final Logger log = Logger.getLogger(SearchTest.class.getName());

  

    

    @Test
    public void searchBySenderIdData() throws Exception {
        log.info("searchData");
        ApiKey apikey = null;
        try {

            PAuthClient pauth = new PAuthClient();
            apikey = pauth.auth("anagnosg", "123456");
            log.info("Apikey:" + new Gson().toJson(apikey));

            SearchClient search = new SearchClient();
            Search s = SearchBuilder.buildDocTypeSender();
            
            List<String> docHashIds = search.search(s, apikey);
            if (docHashIds != null && docHashIds.size() == 0) {
                log.info("docIds size is 0");
            } else {
                for (int i = 0; i < docHashIds.size(); i++) {
                    log.info((i + 1) + ")docHashId:" + docHashIds.get(i));
                }
            }
        } catch (SearchException e) {
        	e.printStackTrace();
            log.severe(e.getMessage());
        } catch (AuthenticateException e) {
            log.severe(e.getMessage());
            e.printStackTrace();
        }
    }

    
    
}
