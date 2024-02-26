API ENDPOINTS

Create a new task
<br>
*** POST/tasks
<br>
Get all tasks if completed=true
<br>
*** GET/tasks
<br>
***** /tasks?completed=true/false
<br>
Get the tasks by id
<br>
*** GET/tasks/{task_id}
<br>

Add/Remove notes from the task. Mark the task completed<br>
*** PATCH/tasks/{task_id}<br>

Delete the task by id<br>
*** DELETE/tasks/{task_id}<br>

Get all notes under a particular task<br>
*** GET/tasks/{task_id}/notes<br>

Add notes under the task with the given task id<br>
*** POST/tasks/{task_id}/notes<br>

Delete notes under the task with the given task ID<br>
*** DELETE/tasks/{task_id}/notes/{notes_id}<br>
