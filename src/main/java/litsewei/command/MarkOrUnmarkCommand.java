package litsewei.command;

import litsewei.Printer;
import litsewei.TaskManager;

/**
 * Command to mark or unmark a task as done.
 */
public class MarkOrUnmarkCommand extends Command{

    private boolean isMarkCommand;

    /**
     * Constructs a MarkOrUnmarkCommand.
     * @param isMarkCommand true if the command is to mark a task, false to unmark
     */
    public MarkOrUnmarkCommand(boolean isMarkCommand) {
        this.isMarkCommand = isMarkCommand;
    }

    @Override
    public boolean isTriggered(String input) {
        if(isMarkCommand) {
            return input.startsWith("mark");
        } else {
            return input.startsWith("unmark");
        }
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

            if (taskManager.getTasks().get(taskId - 1).isDone() == isMarkCommand) {
                Printer.printWithDividingLines("Emm... This task is already " + (isMarkCommand ? "marked" : "unmarked") + "? >_<");
                return;
            }

            taskManager.getTasks().get(taskId - 1).setDone(isMarkCommand);

            if (isMarkCommand) {
                Printer.printWithDividingLines("Marked this as done: " + taskManager.getTasks().get(taskId - 1).getName() + "!! :>");
            } else {
                Printer.printWithDividingLines("Marked this as not done yet: " + taskManager.getTasks().get(taskId - 1).getName() + "!! :<");
            }
        } catch (NumberFormatException e) {
            Printer.printWithDividingLines("I cannot understand >_<. Just give me an ID plz~");
        } catch (IndexOutOfBoundsException e) {
            Printer.printWithDividingLines("The ID you gave me seems wrong >_<. Plz check again~");
        }
    }
}
