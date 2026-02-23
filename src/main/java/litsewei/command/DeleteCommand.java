package litsewei.command;

import litsewei.Printer;
import litsewei.TaskManager;

/**
 * Command to delete a task.
 */
public class DeleteCommand extends Command {
    @Override
    public boolean isTriggered(String input) {
        return input.startsWith("delete");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        try {
            var list = input.split(" ");
            if (list.length == 1) {
                Printer.printWithDividingLines("Which? Please give me an ID...");
                return;
            }

            int taskId = Integer.parseInt(list[1]);
            var removedTask = taskManager.deleteTask(taskId);

            Printer.printWithDividingLines("Deleted this: " + removedTask.getName() + "!! ^^");
        } catch (NumberFormatException e) {
            Printer.printWithDividingLines("I cannot understand >_<. Just give me an ID plz~");
        } catch (IndexOutOfBoundsException e) {
            Printer.printWithDividingLines("The ID you gave me seems wrong >_<. Plz check again~");
        }
    }
}
