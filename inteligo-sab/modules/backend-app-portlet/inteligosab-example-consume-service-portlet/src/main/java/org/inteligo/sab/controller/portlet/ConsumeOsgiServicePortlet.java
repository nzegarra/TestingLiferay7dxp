package org.inteligo.sab.controller.portlet;

import org.inteligo.sab.api.Greeting;
import org.inteligo.sab.controller.constants.ConsumeOsgiServicePortletKeys;
import org.inteligo.sab.service.SampleService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author USUARIO
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.InteligoSabADDService",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=inteligosab-service-consumer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ConsumeOsgiServicePortletKeys.ConsumeOsgiService,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ConsumeOsgiServicePortlet extends MVCPortlet {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(ConsumeOsgiServicePortlet.class);
	
	private SampleService sampleService;
	private Greeting greetingService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		LOGGER.info("MTHOD VIEW");
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		String strNum1 = ParamUtil.getString(resourceRequest, "firstNumber");
		String strNum2 = ParamUtil.getString(resourceRequest, "secondNumber");
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = 0;
		
		if(Validator.isNotNull(sampleService)){
			LOGGER.info(sampleService.getGreeting("Inteligo Sab"));
			LOGGER.info(sampleService.getNameServiceImpl());
			result = sampleService.add(num1, num2);
			LOGGER.info("**************************************");
			LOGGER.info("*************API Greeting*************");
			
			
		}else{
			LOGGER.info("ERROR CALL to Service - SampleService OSGI");
		}
		if(Validator.isNotNull(greetingService)){
			greetingService.greet("Inteligo SAB");
			LOGGER.info(greetingService.operationProduct(num1, num2));
			LOGGER.info(greetingService.operationDivision(num1, num2));
		}else{
			LOGGER.info("ERROR CALL to Service - GREETING SERVICE OSGI");
		}
		LOGGER.info("Suuccess Plus with Service Consumer for Portlet");
		resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();
        writer.print(result);
        writer.flush();
        writer.close();
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	@Reference
	public void setSampleService(SampleService sampleService){
		this.sampleService = sampleService;
	}
	@Reference
	public void setOperationService(Greeting greetingService){
		this.greetingService = greetingService;
	}
	
	
}