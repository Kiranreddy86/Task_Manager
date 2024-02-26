API ENDPOINTS

Create a new task
<br>
--- POST/tasks
<br>
Get all tasks if completed=true
<br>
--- GET/tasks
<br>
------ /tasks?completed=true/false
<br>
Get the tasks by id
<br>
--- GET/tasks/{task_id}

Add/Remove notes from the task. Mark the task completed
--- PATCH/tasks/{task_id}

Delete the task by id
--- DELETE/tasks/{task_id}

Get all notes under a particular task
--- GET/tasks/{task_id}/notes

Add notes under the task with the given task id
--- POST/tasks/{task_id}/notes

Delete notes under the task with the given task ID
--- DELETE/tasks/{task_id}/notes/{notes_id}
