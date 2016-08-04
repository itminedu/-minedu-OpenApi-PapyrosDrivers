package gr.mimedu.papyros.protocol;


import java.lang.reflect.Type;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import gr.mimedu.papyros.protocol.exceptions.AuthenticateException;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.Credentials;
import gr.minedu.papyros.protocol.dto.ErrorReport;
import gr.minedu.papyros.protocol.dto.ResponseModel;
import gr.mineedu.papyros.protocol.idto.Config;
import gr.mineedu.papyros.protocol.idto.OpenPapyrosServices;

import javax.ws.rs.client.Invocation.Builder;      
public class PAuthClient {
	Config conf = new Config();
	private static final Logger logger = Logger.getLogger(PAuthClient.class.getName());
	
	
	public ApiKey auth(String username, String password) throws AuthenticateException{
		ApiKey apikey = null;
		Client client = ClientBuilder.newClient();
		String targetHost=conf.getServerurl();
		String path = OpenPapyrosServices.PAuth.getValue();
		logger.fine("path:"+path);
		WebTarget target = client.target(targetHost).path(path);
		logger.fine("target:"+target);
        Builder builder =   target.request();
        Credentials c = new Credentials ();c.username=username;c.password=password;
        Response response  =  builder.accept(MediaType.APPLICATION_JSON).put(Entity.entity(new Gson().toJson(c),MediaType.APPLICATION_JSON));// put(String.class);
        String responseStr = response.readEntity(String.class);
        logger.finest(responseStr);
        if(response.getStatus()==Response.Status.OK.getStatusCode()){
        	apikey = new Gson().fromJson(responseStr,ApiKey.class) ;
        	logger.finest("apikey:"+apikey);
        }
        else{
        	ErrorReport errorReport =  new Gson().fromJson(responseStr,ErrorReport.class) ;	
        	throw new AuthenticateException(errorReport.getErrorCode(),errorReport.getErrorMessage());
        }
        return apikey;
	}
	
	
	public static void main(String args[]){
		PAuthClient pauth = new PAuthClient();
		try {
			pauth.auth("test", "test2");
		} catch (AuthenticateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
