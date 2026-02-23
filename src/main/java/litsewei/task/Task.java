package litsewei.task;

import java.util.Scanner;

/**
 * Represents a task.
 */
public class Task {
    private String name;
    private boolean isDone;

    /**
     * Constructs a task with the given name.
     * @param name the name of the task
     */
    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    /**
     * Create Task from input string. <br/>
     * For now, it has the same effect as the constructor.
     *
     * @param input - the task name
     * @return The task with the given name
     */
    public static Task from(String input) {
        return new Task(input);
    }

    /**
     * Create Task from a serialized string. <br/>
     * The format should be "type|name|isDone"
     *
     * @return The task created from the serialized string
     */
    public static Task fromSerialized(String serializedString) {
        var split = serializedString.split("\\|");
        String name = split[1].trim();
        boolean isDone = split[2].trim().equals("true");
        Task task = new Task(name);
        task.setDone(isDone);
        return task;
    }

    /**
     * Serializes the task to a string.
     * @return the serialized string
     */
    public String serialize() {
        return getTaskType() + "|" + getName() + "|" + isDone();
    }

    /**
     * Gets the name of the task.
     * @return the name of the task
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the task.
     * @param name the new name of the task
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the task is done.
     * @return true if the task is done, false otherwise
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Sets the done status of the task.
     * @param done the new done status
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    /**
     * Gets the type code of the task.
     * @return the type code
     */
    public String getTaskType() {
        return "T";
    }


    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + (isDone ? "[X] " : "[ ] ") + name;
    }
}
