package litsewei;

import litsewei.command.*;

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
            new SaveCommand()
    };

    public CommandManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

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
