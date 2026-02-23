package litsewei;

import litsewei.exception.SaverException;
import litsewei.task.Deadline;
import litsewei.task.Event;
import litsewei.task.Task;

import java.util.ArrayList;

/**
 * Wraps the list of tasks and provides methods to manipulate the list, such as adding, deleting, loading from disk and saving to disk. <br/>
 */
public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Gets the list of tasks.
     * @return the list of tasks
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a todo task to the list.
     * @param todo the todo task to add
     */
    public void addTodo(Task todo) {
        tasks.add(todo);
    }

    /**
     * Adds a deadline task to the list.
     * @param ddl the deadline task to add
     */
    public void addDeadline(Deadline ddl) {
        tasks.add(ddl);
    }

    /**
     * Adds an event task to the list.
     * @param event the event task to add
     */
    public void addEvent(Event event) {
        tasks.add(event);
    }

    /**
     * Deletes the task with the given taskId from the list of tasks and returns it. <br/>
     * @param taskId - the index of the task to delete, <b>starting from 1</b> as shown in the printed list. <br/>
     * @return the task that was deleted. <br/>
     * @throws IndexOutOfBoundsException if the taskId is out of bounds of the list of tasks. <br/>
     */
    public Task deleteTask(int taskId) {
        return tasks.remove(taskId - 1);
    }


    /**
     * Loads the list of taskManager.getTasks() from disk and assigns it to the taskManager.getTasks() variable. <br/>
     */
    public void loadFromDisk() throws SaverException {
        tasks = Saver.load();

    }

    /**
     * Saves the current list of taskManager.getTasks() to disk. If there is an error during saving, an error message will be printed. <br/>
     */
    public void saveToDisk() throws SaverException {
        Saver.save(tasks);
    }
}
