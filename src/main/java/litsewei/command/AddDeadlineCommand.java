package litsewei.command;

import litsewei.Printer;
import litsewei.TaskManager;
import litsewei.exception.InvalidTaskFormatException;
import litsewei.task.Deadline;

public class AddDeadlineCommand extends Command {
    @Override
    public boolean isTriggered(String input) {
        return input.startsWith("deadline");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        try {
            if (input.length() < 9) {
                Printer.printWithDividingLines("The description of a deadline cannot be empty..?");
                return;
            }

            var ddl = Deadline.from(input.substring(9));
            taskManager.addDeadline(ddl);

            Printer.printWithDividingLines("Remember to do " + ddl.getName() + " by " + ddl.getBy() + "!!!");
        } catch (InvalidTaskFormatException e) {
            Printer.printWithDividingLines("I could not understand that deadline format >_<. Please use: deadline <name> /by <due date>");
        }
    }
}
