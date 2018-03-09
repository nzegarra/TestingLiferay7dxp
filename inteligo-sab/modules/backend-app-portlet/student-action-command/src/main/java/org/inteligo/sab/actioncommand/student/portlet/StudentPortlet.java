package org.inteligo.sab.actioncommand.student.portlet;

import org.inteligo.sab.actioncommand.student.constants.StudentPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author USUARIO
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.InteligoSabPrototype",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=student-action-command Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StudentPortletKeys.Student,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentPortlet extends MVCPortlet {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(StudentPortlet.class);
	
	//Este método no es llamado, es llamado la acción de BaseMVCActionCommand
	public void getStudent2(ActionRequest actionRequest, ActionResponse actionResponse){
		
		LOGGER.info("Methos action of Student Portlet...");
	}
	public void getStudent(ActionRequest actionRequest, ActionResponse actionResponse){
			
			LOGGER.info("Methos action of Student Portlet...REPEAT OF BASEMVCACTIONCOMMAND");
	}
}