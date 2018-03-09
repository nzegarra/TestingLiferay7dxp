package org.inteligo.sab.activator;

import org.inteligo.sab.api.Greeting;
import org.inteligo.sab.service.SampleService;
import org.inteligo.sab.service.impl.SampleServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ServiceActivator implements BundleActivator{

	private static final Log LOGGER = LogFactoryUtil.getLog(ServiceActivator.class);
	
	private ServiceRegistration registration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("START Bundle Inteligo Sab Service Impl");
		SampleService service = new SampleServiceImpl();
		Greeting greetingService = new SampleServiceImpl();
		registration = context.registerService(SampleService.class.getName(), service, null);
		//�por qu� funciona si no  est� registrado el servicio Greeting?
		//�No est� tomando el BundleActivator.... porque as� no se registren los servicios se pueden invocar?
		registration = context.registerService(Greeting.class.getName(), greetingService, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		//registration.unregister();
		LOGGER.info("STOP bundle Inteligo Sab Service Impl");
	}

}
