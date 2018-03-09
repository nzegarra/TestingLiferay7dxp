package org.inteligo.sab.javabrians.activator;

import org.inteligo.sab.api.rest.javabrians.api.MessageApi;
import org.inteligo.sab.javabrians.service.JavaBriansService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class JavaBrianActivator implements BundleActivator{

	private static final Log LOGGER = LogFactoryUtil.getLog(JavaBrianActivator.class);
	private ServiceRegistration<MessageApi> registration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("Start JavaBrian Service Bundle");
		MessageApi serviceMessage = new JavaBriansService();
		
		registration = (ServiceRegistration<MessageApi>)context.registerService(MessageApi.class.getName(), serviceMessage, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("Stop JavaBrian Service Bundle");	
		registration.unregister();
	}

	
}
