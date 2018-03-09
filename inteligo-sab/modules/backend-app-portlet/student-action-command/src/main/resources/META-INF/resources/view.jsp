<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="student-action-command.caption"/></b>
</p>

<portlet:actionURL name="getStudent" var="getStudentURL">
	<portlet:param name="studentId" value="5"/>
</portlet:actionURL>

<portlet:actionURL name="getStudent2" var="getStudent2URL">
	<portlet:param name="studentId" value="5"/>
</portlet:actionURL>

<a href="${getStudentURL}">Cargar modelo usando Action Command URL</a>
<a href="${getStudent2URL}">Cargar modelo usando Action Command URL 2</a>

<br>
