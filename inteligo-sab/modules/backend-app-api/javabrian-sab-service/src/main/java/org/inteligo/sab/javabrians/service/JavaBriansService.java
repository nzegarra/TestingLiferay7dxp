package org.inteligo.sab.javabrians.service;


import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.http.HTTPException;

import org.inteligo.sab.api.rest.javabrians.api.MessageApi;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author USUARIO
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = MessageApi.class
)
public class JavaBriansService implements MessageApi {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(JavaBriansService.class);
	
//	@Override
//	public void getProfiles() {
//		
//		HttpClient client = new HttpClient();
//		GetMethod method = new GetMethod("http://localhost:8085/JAXRSMessage/rest/profiles");
//		method.setRequestHeader("Accept", "application/json");
//		LOGGER.info("INIT CAll the service of JAva Brians API JAX RS with HTTPCLIENT");
//		try {
//			int statusCode = client.executeMethod(method);
//			LOGGER.info("STATUS CODE: "+statusCode);
//			if(statusCode == HttpStatus.SC_OK){
//				LOGGER.info("SUCCES Method API for JavaBrians....");
//				byte []responseBody = method.getResponseBody();
//				LOGGER.info("RESPONSE: "+new String(responseBody));
//			}
//		} catch (IOException | HTTPException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			LOGGER.info("FINALLY RESOURCE API");
//		}
//	}
	
	@Override
	public void getProfiles() {
		
//		HttpClient client = new HttpClient();
//		GetMethod method = new GetMethod("http://localhost:8085/JAXRSMessage/rest/profiles");
//		method.setRequestHeader("Accept", "application/json");
		LOGGER.info("INIT CAll the service of JAva Brians API JAX RS with HTTPCLIENT");
		try {
			Client client = ClientBuilder.newBuilder().newClient();
			WebTarget target = client.target("http://localhost:8085/JAXRSMessage/rest/profiles");
			Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON_TYPE);
			Response response = builder.get();
			LOGGER.info(response.readEntity(String.class));
			}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			LOGGER.info("FINALLY RESOURCE API");
		}
	}
	
//	@Override
//	public void getProfiles() {
//		LOGGER.info("Invicando el servicio de javaBrians");
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target("http://localhost:8085/JAXRSMessage/rest/");
//		WebTarget targetProfile = target.path("profiles");
//		
//		Invocation.Builder invocationBuilder = targetProfile.request(MediaType.APPLICATION_JSON);
//		Response response = invocationBuilder.get();
//		LOGGER.info("Respuesta: "+response.getStatus());
//		return response;
//	}

	// TODO enter required service methods

}