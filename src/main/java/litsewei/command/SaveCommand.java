package litsewei.command;

import litsewei.TaskManager;

public class SaveCommand extends Command {
    @Override
    public boolean isTriggered(String input) {
        return input.equalsIgnoreCase("save");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        taskManager.saveToDisk();
    }
}
