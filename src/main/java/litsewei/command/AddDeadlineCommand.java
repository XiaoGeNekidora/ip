package litsewei.command;

import litsewei.TaskManager;

public class AddDeadlineCommand extends Command {
    @Override
    public boolean isTriggered(String input) {
        return input.startsWith("deadline");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        taskManager.addDeadline(input);
    }
}
