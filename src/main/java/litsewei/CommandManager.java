package litsewei;

import litsewei.command.*;

/**
 * Manages the execution of commands.
 */
public class CommandManager {

    private TaskManager taskManager;

    private Command[] commands = {
            new ListCommand(),
            new MarkOrUnmarkCommand(true),
            new MarkOrUnmarkCommand(false),
            new DeleteCommand(),
            new AddTodoCommand(),
            new AddEventCommand(),
            new AddDeadlineCommand(),
            new SaveCommand(),
            new FindCommand()
    };

    public CommandManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    /**
     * Handles the input command.
     * @param input the input command string
     */
    public void handleCommand(String input) {
        for (Command command : commands) {
            if (command.isTriggered(input)) {
                command.execute(input, taskManager);
                return;
            }
        }

        Printer.printWithDividingLines("I don't quite get it >_<. Can you rephrase?");
    }
}
