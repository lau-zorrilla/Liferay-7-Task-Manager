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

package serviceBuilder.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Task}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Task
 * @generated
 */
@ProviderType
public class TaskWrapper implements Task, ModelWrapper<Task> {
	public TaskWrapper(Task task) {
		_task = task;
	}

	@Override
	public Class<?> getModelClass() {
		return Task.class;
	}

	@Override
	public String getModelClassName() {
		return Task.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("taskId", getTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("finishDate", getFinishDate());
		attributes.put("finished", isFinished());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date finishDate = (Date)attributes.get("finishDate");

		if (finishDate != null) {
			setFinishDate(finishDate);
		}

		Boolean finished = (Boolean)attributes.get("finished");

		if (finished != null) {
			setFinished(finished);
		}
	}

	@Override
	public Object clone() {
		return new TaskWrapper((Task)_task.clone());
	}

	@Override
	public int compareTo(Task task) {
		return _task.compareTo(task);
	}

	/**
	* Returns the company ID of this task.
	*
	* @return the company ID of this task
	*/
	@Override
	public long getCompanyId() {
		return _task.getCompanyId();
	}

	/**
	* Returns the create date of this task.
	*
	* @return the create date of this task
	*/
	@Override
	public Date getCreateDate() {
		return _task.getCreateDate();
	}

	/**
	* Returns the description of this task.
	*
	* @return the description of this task
	*/
	@Override
	public String getDescription() {
		return _task.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _task.getExpandoBridge();
	}

	/**
	* Returns the finish date of this task.
	*
	* @return the finish date of this task
	*/
	@Override
	public Date getFinishDate() {
		return _task.getFinishDate();
	}

	/**
	* Returns the finished of this task.
	*
	* @return the finished of this task
	*/
	@Override
	public boolean getFinished() {
		return _task.getFinished();
	}

	/**
	* Returns the group ID of this task.
	*
	* @return the group ID of this task
	*/
	@Override
	public long getGroupId() {
		return _task.getGroupId();
	}

	/**
	* Returns the modified date of this task.
	*
	* @return the modified date of this task
	*/
	@Override
	public Date getModifiedDate() {
		return _task.getModifiedDate();
	}

	/**
	* Returns the name of this task.
	*
	* @return the name of this task
	*/
	@Override
	public String getName() {
		return _task.getName();
	}

	/**
	* Returns the primary key of this task.
	*
	* @return the primary key of this task
	*/
	@Override
	public long getPrimaryKey() {
		return _task.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _task.getPrimaryKeyObj();
	}

	/**
	* Returns the task ID of this task.
	*
	* @return the task ID of this task
	*/
	@Override
	public long getTaskId() {
		return _task.getTaskId();
	}

	/**
	* Returns the user ID of this task.
	*
	* @return the user ID of this task
	*/
	@Override
	public long getUserId() {
		return _task.getUserId();
	}

	/**
	* Returns the user uuid of this task.
	*
	* @return the user uuid of this task
	*/
	@Override
	public String getUserUuid() {
		return _task.getUserUuid();
	}

	/**
	* Returns the uuid of this task.
	*
	* @return the uuid of this task
	*/
	@Override
	public String getUuid() {
		return _task.getUuid();
	}

	@Override
	public int hashCode() {
		return _task.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _task.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _task.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this task is finished.
	*
	* @return <code>true</code> if this task is finished; <code>false</code> otherwise
	*/
	@Override
	public boolean isFinished() {
		return _task.isFinished();
	}

	@Override
	public boolean isNew() {
		return _task.isNew();
	}

	@Override
	public void persist() {
		_task.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_task.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this task.
	*
	* @param companyId the company ID of this task
	*/
	@Override
	public void setCompanyId(long companyId) {
		_task.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this task.
	*
	* @param createDate the create date of this task
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_task.setCreateDate(createDate);
	}

	/**
	* Sets the description of this task.
	*
	* @param description the description of this task
	*/
	@Override
	public void setDescription(String description) {
		_task.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_task.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_task.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_task.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the finish date of this task.
	*
	* @param finishDate the finish date of this task
	*/
	@Override
	public void setFinishDate(Date finishDate) {
		_task.setFinishDate(finishDate);
	}

	/**
	* Sets whether this task is finished.
	*
	* @param finished the finished of this task
	*/
	@Override
	public void setFinished(boolean finished) {
		_task.setFinished(finished);
	}

	/**
	* Sets the group ID of this task.
	*
	* @param groupId the group ID of this task
	*/
	@Override
	public void setGroupId(long groupId) {
		_task.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this task.
	*
	* @param modifiedDate the modified date of this task
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_task.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this task.
	*
	* @param name the name of this task
	*/
	@Override
	public void setName(String name) {
		_task.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_task.setNew(n);
	}

	/**
	* Sets the primary key of this task.
	*
	* @param primaryKey the primary key of this task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_task.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_task.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the task ID of this task.
	*
	* @param taskId the task ID of this task
	*/
	@Override
	public void setTaskId(long taskId) {
		_task.setTaskId(taskId);
	}

	/**
	* Sets the user ID of this task.
	*
	* @param userId the user ID of this task
	*/
	@Override
	public void setUserId(long userId) {
		_task.setUserId(userId);
	}

	/**
	* Sets the user uuid of this task.
	*
	* @param userUuid the user uuid of this task
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_task.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this task.
	*
	* @param uuid the uuid of this task
	*/
	@Override
	public void setUuid(String uuid) {
		_task.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Task> toCacheModel() {
		return _task.toCacheModel();
	}

	@Override
	public Task toEscapedModel() {
		return new TaskWrapper(_task.toEscapedModel());
	}

	@Override
	public String toString() {
		return _task.toString();
	}

	@Override
	public Task toUnescapedModel() {
		return new TaskWrapper(_task.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _task.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskWrapper)) {
			return false;
		}

		TaskWrapper taskWrapper = (TaskWrapper)obj;

		if (Objects.equals(_task, taskWrapper._task)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _task.getStagedModelType();
	}

	@Override
	public Task getWrappedModel() {
		return _task;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _task.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _task.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_task.resetOriginalValues();
	}

	private final Task _task;
}