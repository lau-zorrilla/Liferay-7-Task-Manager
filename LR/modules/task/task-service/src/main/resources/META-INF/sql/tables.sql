create table task_Task (
	uuid_ VARCHAR(75) null,
	taskId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	finishDate DATE null,
	finished BOOLEAN
);