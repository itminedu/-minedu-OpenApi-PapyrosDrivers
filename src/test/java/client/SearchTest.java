package client;

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


public class SearchTest {
private static final Logger log = Logger.getLogger(EAuthTest.class.getName());
	
	@Test
    public void searchCredentials() throws Exception {
     	log.info("searchCredentials");
     	SearchClient search = new SearchClient();
		try {
			Search s = new Search();
			
			search.search(s,null);
		} catch (AuthenticateException e) {
			log.severe(e.getMessage());
		}
		 catch (SearchException e) {
			log.severe(e.getMessage());
		}
    }
	
	@Test
	public void searchNoData() throws Exception {
     	log.info("searchNoData");
     	ApiKey apikey  = null;
		try {
			
			PAuthClient pauth = new PAuthClient();
			apikey  = pauth.auth("string", "string");
			log.info("Apikey:"+new Gson().toJson(apikey));
			
			SearchClient search = new SearchClient();
			Search s = new Search();
			List<String> docHashIds =  search.search(s,apikey);
			if(docHashIds!=null && docHashIds.size()==0 ){
				log.info("docIds size is 0");
			}
		} catch (SearchException e) {
			log.severe(e.getMessage());
		}
		catch (AuthenticateException e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		}
    }
	
	@Test
	public void searchData() throws Exception {
     	log.info("searchData");
     	ApiKey apikey  = null;
		try {
			
			PAuthClient pauth = new PAuthClient();
			apikey  = pauth.auth("string", "string");
			log.info("Apikey:"+new Gson().toJson(apikey));
			
			SearchClient search = new SearchClient();
			Search s = new Search();
			s.setSenderId(1000000);
			List<String> docHashIds =  search.search(s,apikey);
			if(docHashIds!=null && docHashIds.size()==0 ){
				log.info("docIds size is 0");
			}
			else{
				for(int i = 0 ; i < docHashIds.size() ; i ++ ){
					log.info((i+1)+")docHashId:"+docHashIds.get(i));
				}
			}
		} catch (SearchException e) {
			log.severe(e.getMessage());
		}
		catch (AuthenticateException e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		}
    }
	
	
}
