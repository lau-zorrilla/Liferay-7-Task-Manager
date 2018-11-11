/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package serviceBuilder.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import serviceBuilder.exception.NoSuchTaskException;
import serviceBuilder.model.Task;
import serviceBuilder.service.TaskLocalServiceUtil;
import serviceBuilder.service.base.TaskLocalServiceBaseImpl;

/**
 * The implementation of the task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link serviceBuilder.service.TaskLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskLocalServiceBaseImpl
 * @see serviceBuilder.service.TaskLocalServiceUtil
 */
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link serviceBuilder.service.TaskLocalServiceUtil} to access the task local service.
	 */
	
	public Task editTask(long taskId, String name, String description, Date createDate, Date finishDate, boolean finished, 
			Date modifiedDate, long userId, long groupId, long companyId){
		
		Task task = null;
		
		try {
			task = TaskLocalServiceUtil.getTask(taskId);
		} catch (PortalException e) {
			task = TaskLocalServiceUtil.createTask(CounterLocalServiceUtil.increment(Task.class.getName()));
		}
		
		task.setName(name);
		task.setDescription(description);
		task.setCreateDate(createDate);
		task.setFinishDate(finishDate);
		task.setFinished(finished);
		task.setModifiedDate(modifiedDate);
		task.setUserId(userId);
		task.setGroupId(groupId);
		task.setCompanyId(companyId);
		
		task = TaskLocalServiceUtil.updateTask(task);
		
		return task;
	}
	
	public List<Task> getTasks(long userId){
		return taskPersistence.findByByUserId(userId);
	}
	
	public int getTaskCount(long userId) {

	    return taskPersistence.countByByUserId(userId);
	}
	
	protected void validate(long taskId) throws PortalException {
	    if (Validator.isNull(taskId)) {
	        throw new NoSuchTaskException();
	    }
	}
}