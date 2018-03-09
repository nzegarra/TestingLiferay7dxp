<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="inteligosab-example-consume-service-portlet.caption"/></b>
</p>

<portlet:resourceURL var="sumResourceURL"/>

<aui:form name="fm">
   
     
    <!-- Use of prefix and suffix -->
    <aui:input  name="firstNumber" label="" prefix="First Number"/>
     <aui:input  name="secondNumber" label="" prefix="Second Number"/>
     <aui:input  name="result" id="result"  label="" prefix="Result"/>
 
     <aui:button name="name" value="Calculate" onclick="callServeResource()"/>
     
</aui:form>

<script type="text/javascript">
function callServeResource(){
    AUI().use('aui-io-request', function(A){
        A.io.request('<%=sumResourceURL.toString()%>', {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>fm'
               },
               on: {
                    success: function() {
                    // alert(this.get('responseData'));
                     
                     var result = this.get('responseData');
                     var resultLabel = A.one('#<portlet:namespace/>result')
                	resultLabel.val(result)
                    }
               }
            });
    });
}
</script>