package task.manager.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import serviceBuilder.model.Task;
import serviceBuilder.service.TaskLocalServiceUtil;
import task.manager.constants.TaskManagerPortletKeys;

/**
 * @author lau
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TaskManagerPortletKeys.TaskManager,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TaskManagerPortlet extends MVCPortlet {
	/** Task manager for portal user with site administration permission
	 * 
	 * @param renderRequest Request from the view
	 * @param renderResponse Response from the view
	 * 
	 */
	
	private static Log _log = LogFactoryUtil.getLog(TaskManagerPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) 
			throws IOException, PortletException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long taskId = ParamUtil.get(renderRequest, "taskId", -1);
		
		if(taskId != -1){
			getTask(renderRequest, taskId);
		}else{
			List<Task> taskList = new ArrayList<Task>();
			taskList = TaskLocalServiceUtil.getTasks(themeDisplay.getUserId());
			renderRequest.setAttribute("taskList", taskList);
		}
		
		renderRequest.setAttribute("taskId", taskId);
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) 
			throws IOException, PortletException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long taskId = ParamUtil.get(renderRequest, "taskId", -1);
		
		List<Task> taskList = new ArrayList<Task>();
		taskList = TaskLocalServiceUtil.getTasks(themeDisplay.getUserId());
		
		renderRequest.setAttribute("taskList", taskList);
		renderRequest.setAttribute("taskId", taskId);
		
		super.doView(renderRequest, renderResponse);
	}
	
	public void getTask(RenderRequest renderRequest, long taskId){
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Task task = null;
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		ResourceBundle rb = portletConfig.getResourceBundle(themeDisplay.getLocale());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String name = LanguageUtil.format(rb, "task.enter-name", "");
		String description = LanguageUtil.format(rb, "task.enter-description", "");
		String startDateStr = sdf.format(new Date());
		String finishDateStr = sdf.format(new Date());
		boolean finished = false;
		
		if(taskId != 0){
			try {
				task = TaskLocalServiceUtil.getTask(taskId);
				name = task.getName();
				description = task.getDescription();
				startDateStr = sdf.format(task.getCreateDate());
				System.out.println("startDateStr after: " + startDateStr);
				finishDateStr = sdf.format(task.getFinishDate());
				System.out.println("finishDateStr before: " + finishDateStr);
				finished = task.getFinished();
			} catch (PortalException e) {
				_log.debug("There are no task with id " + taskId);
			}
		}
		
		renderRequest.setAttribute("name", name);
		renderRequest.setAttribute("description", description);
		renderRequest.setAttribute("createDate", startDateStr);
		renderRequest.setAttribute("finishDateStr", finishDateStr);
		renderRequest.setAttribute("finished", finished);
	}
	
	@ProcessAction(name="editTask")
	public void editTask(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		long taskId = ParamUtil.getLong(actionRequest, "taskId");
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description", "");
		Date createDate = ParamUtil.getDate(actionRequest, "createDate", sdf, new Date());
		Date finishDate = ParamUtil.getDate(actionRequest, "finishDate", sdf);
		Date modifiedDate = new Date();
		boolean finished = ParamUtil.getBoolean(actionRequest, "finished", false);
		
		//create new task if name exits. Otherwise return error 
		if(!"".equals(name)){
			TaskLocalServiceUtil.editTask(taskId, name, description, createDate, 
					finishDate, finished, modifiedDate, themeDisplay.getUserId(), 
					themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId());
			actionRequest.setAttribute("taskId", -1);
//			include( "/view.jsp", actionRequest, actionResponse );
			
		}else{
			SessionErrors.add(actionRequest, "name-is-required");
			actionRequest.setAttribute("taskId", taskId);
			actionRequest.setAttribute("name", name);
			actionRequest.setAttribute("description", description);
			actionRequest.setAttribute("createDate", createDate);
			actionRequest.setAttribute("finishDate", finishDate);
			actionRequest.setAttribute("finished", finished);
			include( "/edit.jsp", actionRequest, actionResponse );
		}
	}

}