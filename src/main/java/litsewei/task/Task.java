package litsewei.task;

import java.util.Scanner;

public class Task {
    private String name;
    private boolean isDone;

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

    public String serialize() {
        return getTaskType() + "|" + getName() + "|" + isDone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getTaskType() {
        return "T";
    }


    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + (isDone ? "[X] " : "[ ] ") + name;
    }
}
