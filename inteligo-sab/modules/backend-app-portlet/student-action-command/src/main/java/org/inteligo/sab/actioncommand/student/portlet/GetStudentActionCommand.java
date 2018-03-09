package org.inteligo.sab.actioncommand.student.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.inteligo.sab.actioncommand.student.constants.StudentPortletKeys;
import org.inteligo.sab.api.rest.javabrians.api.MessageApi;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+StudentPortletKeys.Student,
				"mvc.command.name=getStudent"
		},
		service = MVCActionCommand.class
		)


public class GetStudentActionCommand extends BaseMVCActionCommand{

	private static final Log LOGGER = LogFactoryUtil.getLog(GetStudentActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		LOGGER.info("GetStudentActionCommand.doProcessAction");
		_handleActionCommand(actionRequest);
		LOGGER.info("Escapar HTML: "+HtmlUtil.escape("<a href='etiqueta'>Este es una etiqueta link</a>"));
		LOGGER.info("FULL_NAME sin Scpae with htmlutil: "+themeDisplay.getUser().getFullName());
		String userFullName = HtmlUtil.escape(themeDisplay.getUser().getFullName());
		LOGGER.info("FULL_NAME: "+userFullName);
		LOGGER.info("Comienza la llamada al servicio... RESTful JavaBrian");
		serviceMessageApi.getProfiles();
		LOGGER.info("Terminó la consulta REST full de JavaBrian....");
		actionResponse.setRenderParameter("mvcPath", "/student_details.jsp");
	}

	
	private void _handleActionCommand(ActionRequest actionRequest){
		
		long studentId = ParamUtil.getLong(actionRequest, "studentId");
		actionRequest.setAttribute("student", "Studiante cargado de la DB");
		actionRequest.setAttribute("comingForm", GetStudentActionCommand.class.getName());
	}
	
	@Reference
	private MessageApi serviceMessageApi;
}

