package org.inteligo.sab.service.impl;

import org.inteligo.sab.api.Greeting;
import org.inteligo.sab.service.SampleService;
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
	service = {
			SampleService.class,
			Greeting.class
	}
)
public class SampleServiceImpl implements SampleService, Greeting{
	private static final Log LOGGER = LogFactoryUtil.getLog(SampleServiceImpl.class);
	@Override
	public int add(int num1, int num2) {
		LOGGER.info("Methos init ADD");
		return (num1 + num2);
	}

	@Override
	public String getGreeting(String name) {
		// TODO Auto-generated method stub
		LOGGER.info("method get Greeting");
		return String.format("Welcomen at First Service OSGI : ", name);
	}

	@Override
	public String getNameServiceImpl() {
		// TODO Auto-generated method stub
		LOGGER.info("Method get Name of Service");
		return SampleServiceImpl.class.getName();
	}

	@Override
	public void greet(String name) {
		// TODO Auto-generated method stub
		LOGGER.info("Other Welcome to Inteligo Sab");
	}

	@Override
	public int operationProduct(int num1, int num2) {
		// TODO Auto-generated method stub
		LOGGER.info("METHOD Operation Product");
		return (num1 + num2);
	}

	@Override
	public float operationDivision(int num1, int num2) {
		// TODO Auto-generated method stub
		LOGGER.info("METHOD Operation Division");
		return (num1/num2);
	}

	// TODO enter required service methods

}