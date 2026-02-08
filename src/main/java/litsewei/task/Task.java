package litsewei.task;

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
     * @param input - the task name
     * @return The task with the given name
     */
    public static Task from(String input) {
        return new Task(input);
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
