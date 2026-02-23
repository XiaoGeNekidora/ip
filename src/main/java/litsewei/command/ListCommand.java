package litsewei.command;

import litsewei.Printer;
import litsewei.TaskManager;

/**
 * Command to list all tasks.
 */
public class ListCommand extends Command{
    @Override
    public boolean isTriggered(String input) {
        return input.equalsIgnoreCase("list");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        Printer.printList(taskManager.getTasks());
    }
}
