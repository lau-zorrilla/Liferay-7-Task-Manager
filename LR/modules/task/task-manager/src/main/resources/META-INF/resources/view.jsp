<%@ include file="/init.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:renderURL var="addTaskURL" >
	<portlet:param name="mvcPath" value="/edit.jsp" />
	<portlet:param name="taskId" value="0" />
</portlet:renderURL>

<div id="task-list-container">
	<liferay-ui:success key="success" message="success"/>
	<c:choose>
		<c:when test="${taskList.size() > 0}">
			<div id="task-table">
				<div id="task-headers">
					<h3 class="task-header"><liferay-ui:message key="task-name"></liferay-ui:message></h3>
					<h3 class="task-header"><liferay-ui:message key="task-description"></liferay-ui:message></h3>
					<h3 class="task-header"><liferay-ui:message key="task-createDate"></liferay-ui:message></h3>
					<h3 class="task-header"><liferay-ui:message key="task-finishDate"></liferay-ui:message></h3>
					<h3 class="task-header"><liferay-ui:message key="task-finished"></liferay-ui:message></h3>
				</div>
				<c:forEach items="${taskList}" var="task" >
				<portlet:renderURL var="editTaskURL">
				    <portlet:param name="mvcPath" value="/edit.jsp" />
				    <portlet:param name="taskId" value="${task.taskId}" />
				</portlet:renderURL>
				<div id="task-container">
					<p class="task-content">${task.name}</p>
					<p class="task-content" id="task-description">${task.description}</p>
					<p class="task-content"><fmt:formatDate pattern='dd/mm/yyyy' value='${task.createDate}'/></p>
					<p class="task-content"><fmt:formatDate pattern='dd/mm/yyyy' value='${task.finishDate}'/></p>
					<p class="task-content">${task.finished == false ? 'No' : 'Yes'}</p>
					<div id="task-link">
						<a href="${editTaskURL}">
							<p><liferay-ui:message key="task.edit-task"></liferay-ui:message></p>
						</a>
					</div>
				</div>
				</c:forEach>
			</div>
		</c:when>
		<c:otherwise>
			<p><liferay-ui:message key="task.no-tasks"></liferay-ui:message></p>
		</c:otherwise>
	</c:choose>
	<aui:button type="button" name="addTaskButton" value="add" href="${addTaskURL}" />
</div>

<style>
#task-table{
	margin-bottom: 4%;
}
#task-list-container{
	display: table;
}
#task-headers{
	disply: table-header-group;
}
.task-header{
	display: table-cell;
	border-top: 1px solid #BBB;
	min-width:160px;
	padding:1%;
}
#task-container{
	display: table-row-group;
}
.task-content{
	display: table-cell;
	border-top: 1px solid #BBB;
	min-width:160px;
	padding:1%;
}
#task-description{
	
}
</style>
