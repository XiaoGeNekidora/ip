package litsewei.command;

import litsewei.Printer;
import litsewei.TaskManager;

public class DeleteCommand extends Command{
    @Override
    public boolean isTriggered(String input) {
        return input.startsWith("delete");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        taskManager.deleteTask(input);
    }
}
