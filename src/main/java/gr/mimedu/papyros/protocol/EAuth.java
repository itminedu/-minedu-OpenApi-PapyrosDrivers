/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.mimedu.papyros.protocol;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gr.mimedu.papyros.protocol.exceptions.AuthenticateException;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.Credentials;
import gr.minedu.papyros.protocol.dto.ResponseModel;
import gr.mineedu.papyros.protocol.model.Config;
import gr.mineedu.papyros.protocol.model.OpenPapyrosServices;
import java.lang.reflect.Type;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pkaratzas
 */
public class EAuth {
    
    Config conf = new Config();
    private static final Logger logger = Logger.getLogger(EAuth.class.getName());

    public ApiKey auth(String username, String password) throws AuthenticateException {
        Client client = ClientBuilder.newClient();
        String targetHost = conf.getServerurl();
        String path = OpenPapyrosServices.PAuth.getValue();
        logger.fine("path:" + path);
        WebTarget target = client.target(targetHost).path(path);
        logger.fine("target:" + target);
        Invocation.Builder builder = target.request();
        Credentials c = new Credentials();
        c.username = username;
        c.password = password;
        Response response = builder.accept(MediaType.APPLICATION_JSON).put(Entity.entity(new Gson().toJson(c), MediaType.APPLICATION_JSON));// put(String.class);
        String responseStr = response.readEntity(String.class);
        logger.finest(responseStr);
        Type returnType = new TypeToken<ResponseModel<ApiKey>>() {
        }.getType();
        ResponseModel<ApiKey> resp = new Gson().fromJson(responseStr, returnType);//ResponseModel<ApiKey>
        ApiKey apikey = null;
        if (resp.getCode() != Response.Status.OK.getStatusCode() || resp.getData() == null) {
            throw new AuthenticateException(resp.getCode(), resp.getMessage());
        } else {
            apikey = resp.getData();
            logger.finest("apikey:" + apikey);
        }
        return apikey;
    }

    public static void main(String args[]) {
        PAuth pauth = new PAuth();
        try {
            pauth.auth("test", "test2");
        } catch (AuthenticateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
