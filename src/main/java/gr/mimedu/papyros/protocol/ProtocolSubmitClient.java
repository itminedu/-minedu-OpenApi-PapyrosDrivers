/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.mimedu.papyros.protocol;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gr.mimedu.papyros.protocol.exceptions.AuthenticateException;
import gr.mimedu.papyros.protocol.exceptions.ProtocolException;
import gr.mimedu.papyros.protocol.exceptions.SearchException;
import gr.mimedu.papyros.protocol.utils.GsonUtils;
import gr.minedu.papyros.protocol.dto.ApiKey;
import gr.minedu.papyros.protocol.dto.ErrorReport;
import gr.minedu.papyros.protocol.dto.ProtocolNumber;
import gr.minedu.papyros.protocol.dto.Protocolin;
import gr.mineedu.papyros.protocol.idto.Config;
import gr.mineedu.papyros.protocol.idto.OpenPapyrosServices;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.internal.util.Base64;

/**
 *
 * @author pkaratzas
 */
public class ProtocolSubmitClient {

    Config conf = new Config();
    private static final Logger logger = Logger.getLogger(Protocolin.class.getName());

    public ProtocolNumber submitProtocol(Protocolin protocolin, ApiKey apikey) throws AuthenticateException, IOException, ProtocolException {
        if (apikey == null) {
            throw new AuthenticateException(0, "Api key is null");
        }
        List<String> output = new ArrayList<String>();
        ProtocolNumber protocolNumber = new ProtocolNumber();
        Client client = ClientBuilder.newClient();
        String targetHost = conf.getServerurl();
        String path = OpenPapyrosServices.SubmitProtocol.getValue();
        logger.fine("path: " + path);
        WebTarget target = client.target(targetHost).path(path);
        Builder builder = target.request();
       
        //protocolin.setDocument(document);
        Response response = builder.header("api_key", apikey.getApiKey()).accept(MediaType.APPLICATION_JSON).post(Entity.entity( GsonUtils.build().toJson(protocolin), MediaType.APPLICATION_JSON));// put(String.class);
        String responseStr = response.readEntity(String.class);
        logger.fine(responseStr);
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
//            Type returnType = new TypeToken<List<String>>() {
//            }.getType();
            ProtocolNumber protNum = new ProtocolNumber();
            protocolNumber = new Gson().fromJson(responseStr, protNum.getClass());
            logger.finest("responseStr:" + protocolNumber);
        } else {
            ErrorReport errorReport = new Gson().fromJson(responseStr, ErrorReport.class);
            throw new ProtocolException(errorReport.getErrorCode(), errorReport.getErrorMessage());
        }
        return protocolNumber;
    }
}
