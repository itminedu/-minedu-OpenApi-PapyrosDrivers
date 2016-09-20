package gr.mimedu.papyros.protocol;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import gr.mimedu.papyros.protocol.exceptions.AuthenticateException;
import gr.mimedu.papyros.protocol.exceptions.SearchException;
import gr.mimedu.papyros.protocol.utils.GsonUtils;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.Document;

import gr.minedu.papyros.protocol.dto.DocumentDataDto;
import gr.minedu.papyros.protocol.dto.ErrorReport;
import gr.minedu.papyros.protocol.dto.Search;
import gr.mineedu.papyros.protocol.idto.Config;
import gr.mineedu.papyros.protocol.idto.OpenPapyrosServices;

public class DocumentClient {
	Config conf = new Config();
	private static final Logger logger = Logger.getLogger(Search.class.getName());
	
	
	public Document getPdf(String docHashId,ApiKey apikey) throws SearchException, AuthenticateException {
		if(apikey==null){throw  new AuthenticateException(0,"Api key is null");}
		
		Document output = new Document();
		Client client = ClientBuilder.newClient();
		String targetHost=conf.getServerurl();
		String path = OpenPapyrosServices.GetDocumentPdf.getValue()+"/"+docHashId;
		logger.fine("path:"+path);
		WebTarget target = client.target(targetHost).path(path);
		logger.fine("target:"+target);
        Builder builder =   target.request();
        //headers.get("api_key")
        Response response  =  builder.header("api_key", apikey.getApiKey()).accept(MediaType.APPLICATION_JSON).get();// put(String.class);
        String responseStr = response.readEntity(String.class);
        logger.finest(responseStr);
        
        if(response.getStatus()==Response.Status.OK.getStatusCode()){
            output = new Gson().fromJson(responseStr,Document.class) ;
        }
        else{
        	ErrorReport errorReport =  new Gson().fromJson(responseStr,ErrorReport.class) ;	
        	throw new SearchException(errorReport.getErrorCode(),errorReport.getErrorMessage());
        }
        return output;
	}
	
	
	public DocumentDataDto getDocumentData(String docHashId,ApiKey apikey) throws SearchException, AuthenticateException, UnsupportedEncodingException {
		if(apikey==null){throw  new AuthenticateException(0,"Api key is null");}
		
		DocumentDataDto output = new DocumentDataDto();
		Client client = ClientBuilder.newClient();
		String targetHost=conf.getServerurl();
		String urlEncoded=URLEncoder.encode(docHashId,"UTF-8");
		String path = OpenPapyrosServices.GetDocumentData .getValue()+"/"+urlEncoded;
		logger.fine("path:"+path);
		WebTarget target = client.target(targetHost).path(path);
		logger.fine("target:"+target);
        Builder builder =   target.request();
        //headers.get("api_key")
        Response response  =  builder.header("api_key", apikey.getApiKey()).accept(MediaType.APPLICATION_JSON).get();// put(String.class);
        String responseStr = response.readEntity(String.class);
        logger.finest("getDocumentData responseStr: "+responseStr);
        
        if(response.getStatus()==Response.Status.OK.getStatusCode()){
            output = GsonUtils.build().fromJson(responseStr,DocumentDataDto.class) ;
        	//output = new Gson().fromJson(responseStr, DocumentDataDto.class);
        }
        else{
        	ErrorReport errorReport =  new Gson().fromJson(responseStr,ErrorReport.class) ;	
        	throw new SearchException(errorReport.getErrorCode(),errorReport.getErrorMessage());
        }
        return output;
	}
	
}
