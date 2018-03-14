package org.inteligo.sab.javabrians.service;


import java.io.IOException;
import java.io.InputStream;

import javax.xml.ws.http.HTTPException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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
	private static final String URL_WS_PROFILE = "http://localhost:8085/JAXRSMessage/rest/profiles";
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
		
		
		LOGGER.info("INIT CAll the service of JAva Brians API JAX RS with HTTPCLIENT");
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			
			HttpGet httpGet = new HttpGet(URL_WS_PROFILE);
			HttpResponse response = httpClient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			switch(statusLine.getStatusCode()){
			case HttpStatus.SC_OK:
				HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			LOGGER.info("Respuestas: "+IOUtils.toString(is, "UTF-8"));
			case HttpStatus.SC_UNAUTHORIZED:
				LOGGER.error("Ocurrio un erro al incocar el servicio");
				
			default:
				LOGGER.error("Cualquier otro error....");
			}
			
		} catch (IOException | HTTPException e) {
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