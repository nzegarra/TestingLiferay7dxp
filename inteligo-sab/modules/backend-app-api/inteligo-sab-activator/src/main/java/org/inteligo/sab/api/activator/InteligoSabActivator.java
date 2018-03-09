package org.inteligo.sab.api.activator;

import org.inteligo.sab.api.Greeting;
import org.inteligo.sab.service.SampleService;
import org.inteligo.sab.service.impl.SampleServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author USUARIO
 */
public class InteligoSabActivator implements BundleActivator {
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		LOGGER.info("START bundle Inteligo Sab Activator...");
		Greeting greetingService = new SampleServiceImpl();
		SampleService sampleService = new SampleServiceImpl();
		
		registration = bundleContext.registerService(Greeting.class, greetingService, null);
		registration = bundleContext.registerService(SampleService.class, sampleService, null);
		
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		LOGGER.info("STOP Bundle Inteligo Sab Activator...");
		registration.unregister();
	}
	
	private static final Log LOGGER = LogFactoryUtil.getLog(InteligoSabActivator.class);
	private ServiceRegistration registration;
	
}