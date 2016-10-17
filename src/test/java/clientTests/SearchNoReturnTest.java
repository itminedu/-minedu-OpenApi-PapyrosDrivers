package clientTests;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import com.google.gson.Gson;

import gr.mimedu.papyros.protocol.PAuthClient;
import gr.mimedu.papyros.protocol.SearchClient;
import gr.mimedu.papyros.protocol.exceptions.AuthenticateException;
import gr.mimedu.papyros.protocol.exceptions.SearchException;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.Search;

public class SearchNoReturnTest {
	
	private static final Logger log = Logger.getLogger(SearchTest.class.getName());
	
	@Test
    public void searchNoCriteriaData() throws Exception {
        log.info("searchNoData");
        ApiKey apikey = null;
        try {
            PAuthClient pauth = new PAuthClient();
            apikey = pauth.auth("anagnosg", "123456");
            log.info("Apikey:" + new Gson().toJson(apikey));

            SearchClient search = new SearchClient();
            Search s = new Search();
            List<String> docHashIds = search.search(s, apikey);
            if (docHashIds != null && docHashIds.size() == 0) {
                log.info("docIds size is 0");
            }
            else{
            	log.info("size:"+docHashIds.size());
            	//log.info(new Gson().toJson(docHashIds));
            }
        } catch (SearchException e) {
            log.severe(e.getMessage());
        } catch (AuthenticateException e) {
            log.severe(e.getMessage());
            e.printStackTrace();
        }
    }
}
