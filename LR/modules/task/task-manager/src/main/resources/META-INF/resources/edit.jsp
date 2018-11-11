<%@ include file="/init.jsp" %>

<portlet:actionURL name="editTask" var="editTaskURL" />
<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<aui:form name="viewTask" id="viewTaskForm" method="post" action="${editTaskURL}" >
	<liferay-ui:error key="name-is-required" message="name-is-required"/>
	<aui:input label="task-id" name="taskId" type="hidden" value="${taskId}"/>
	<aui:input label="task-name" name="name" type="text" value="${name}"/>
	<aui:input label="task-description" name="description" type="textarea" value="${description}"/>
	<aui:input label="task-createDate" name="createDate" type="text" readOnly="true" value="${createDate}"/>
	<div id="task-finish-date">
		<label class="control-label"><liferay-ui:message key="task-finishDate"></liferay-ui:message></label>
	    <input name="finishDate" class="form-control date task-date" type="text" placeholder="dd/mm/yyyy" value="${finishDateStr}">
    </div>
	<aui:input label="task-finished" name="finished" type="checkbox" value="${finished}"/>
	<aui:button-row>
		<aui:button type="submit" name="saveTaskButton" value="save" />
		<aui:button type="button" name="cancelTaskButton" value="cancel" href="${backURL}" />
	</aui:button-row>
</aui:form>


<aui:script>
    AUI().use(
        'aui-datepicker',
        function(A) {
            new A.DatePicker({
                trigger: '.date',
                mask: '%d/%m/%Y',
                popover: {
                    zIndex: 1000
                }
            });
        }
    );
</aui:script>

<style>
.task-date{
	min-width: 120px;
	max-width: 160px;
}
#<portlet:namespace/>createDate{
	min-width: 120px;
	max-width: 160px;
}
#task-finish-date{
	padding-bottom: 2%;
}
</style>