package litsewei.command;

import litsewei.TaskManager;

public class AddEventCommand extends Command {
    @Override
    public boolean isTriggered(String input) {
        return input.startsWith("event");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        taskManager.addEvent(input);
    }
}
