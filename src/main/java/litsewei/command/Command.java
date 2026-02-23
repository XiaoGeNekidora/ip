package litsewei.command;

import litsewei.TaskManager;

/**
 * Represents an abstract command that can be executed by the user. <br/>
 * Each command should implement the isTriggered and execute methods. <br/>
 */
public abstract class Command {
    /**
     * Checks if the command is triggered by the given input. <br/>
     * @return true if the command will be triggered, false otherwise. <br/>
     */
    public abstract boolean isTriggered(String input);

    /**
     * Executes the command and returns the response to be printed. <br/>
     */
    public abstract void execute(String input, TaskManager taskManager);
}
