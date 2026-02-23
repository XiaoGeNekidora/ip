package litsewei.command;

import litsewei.TaskManager;

public abstract class Command {
    /**
     * Checks if the command is triggered by the given input. <br/>
     */
    public abstract boolean isTriggered(String input);

    /**
     * Executes the command and returns the response to be printed. <br/>
     * @return the response to be printed after executing the command
     */
    public abstract void execute(String input, TaskManager taskManager);
}
