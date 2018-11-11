create index IX_FD30CF85 on task_Task (userId, finished);
create index IX_1B4AF2D9 on task_Task (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A0745B9B on task_Task (uuid_[$COLUMN_LENGTH:75$], groupId);