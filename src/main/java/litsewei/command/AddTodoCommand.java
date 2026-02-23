package litsewei.command;

import litsewei.Printer;
import litsewei.TaskManager;
import litsewei.task.Task;

public class AddTodoCommand extends Command {
    @Override
    public boolean isTriggered(String input) {
        return input.startsWith("todo");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        if (input.length() < 5) {
            Printer.printWithDividingLines("The description of a todo cannot be empty..?");
            return;
        }

        var task = new Task(input.substring(5));
        taskManager.addTodo(task);

        Printer.printWithDividingLines("I've noted down this todo: " + task.getName() + "!!!");
    }
}
