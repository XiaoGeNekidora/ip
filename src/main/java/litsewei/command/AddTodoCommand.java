package litsewei.command;

import litsewei.TaskManager;

public class AddTodoCommand extends Command {
    @Override
    public boolean isTriggered(String input) {
        return input.startsWith("todo");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        taskManager.addTodo(input);
    }
}
