package litsewei.command;

import litsewei.Printer;
import litsewei.TaskManager;
import litsewei.exception.InvalidTaskFormatException;
import litsewei.task.Event;

/**
 * Command to add an event task.
 */
public class AddEventCommand extends Command {
    @Override
    public boolean isTriggered(String input) {
        return input.startsWith("event");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        try {
            if (input.length() < 6) {
                Printer.printWithDividingLines("The description of an event cannot be empty..?");
                return;
            }

            var event = Event.from(input.substring(6));
            taskManager.addEvent(event);

            Printer.printWithDividingLines(String.format("Noted the event: %s (from: %s to: %s)!!!",
                    event.getName(), event.getStart(), event.getEnd()));
        } catch (InvalidTaskFormatException e) {
            Printer.printWithDividingLines("I could not understand that event format >_<. Please use: event <name> /from <start time> /to <end time>");
        }
    }
}
