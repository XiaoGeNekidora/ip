# LitSewei User Guide

LitSewei is a desktop application for managing tasks. It is optimized for use via a Command Line Interface (CLI).

## Features

### List all tasks: `list`

Shows a list of all tasks currently in the task manager.

Format: `list`

Expected output:
```
Here is the TODO list:
1.[T][ ] read book
2.[D][ ] return book (by: Sunday)
3.[E][ ] project meeting (from: Mon 2pm to: 4pm)
```

### Adding a Todo: `todo`

Adds a standard todo task to the list.

Format: `todo <description>`

Example: `todo read book`

Expected output:
```
I've noted down this todo: read book!!!
```

### Adding a Deadline: `deadline`

Adds a task with a specific deadline.

Format: `deadline <description> /by <date>`

Example: `deadline return book /by Sunday`

Expected output:
```
Remember to do return book by Sunday!!!
```

### Adding an Event: `event`

Adds an event which takes place within a specific time period.

Format: `event <description> /from <start time> /to <end time>`

Example: `event project meeting /from Mon 2pm /to 4pm`

Expected output:
```
Noted the event: project meeting (from: Mon 2pm to: 4pm)!!!
```

### Mark a task as done: `mark`

Marks a task as done.

Format: `mark <task_index>`

Example: `mark 1`

Expected output:
```
Marked this as done: read book!! :>
```

### Mark a task as not done: `unmark`

Marks a task as not done.

Format: `unmark <task_index>`

Example: `unmark 1`

Expected output:
```
Marked this as not done yet: read book!! :<
```

### Deleting a task: `delete`

Deletes a task from the list.

Format: `delete <task_index>`

Example: `delete 1`

Expected output:
```
Deleted this: read book!! ^^
```

### Finding tasks: `find`

Finds tasks whose names contain the given keyword.

Format: `find <keyword>`

Example: `find book`

Expected output:
```
Here is the filtered TODO list:
1.[T][ ] read book
2.[D][ ] return book (by: Sunday)
```

### Saving data: `save`

Manually saves the current tasks to disk.

Format: `save`

Expected output:
```
Saved successfully!!!
```

### Exiting the program: `bye`

Exits the program.

Format: `bye`

Expected output:
```
Bye. See you next time~~~
```
