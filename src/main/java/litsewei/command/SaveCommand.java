package litsewei.command;

import litsewei.Printer;
import litsewei.Saver;
import litsewei.TaskManager;
import litsewei.exception.SaverException;

/**
 * Command to save tasks to disk.
 */
public class SaveCommand extends Command {
    @Override
    public boolean isTriggered(String input) {
        return input.equalsIgnoreCase("save");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        try {
            taskManager.saveToDisk();
            Printer.printWithDividingLines("Saved successfully!!!");
        } catch (SaverException e) {
            Printer.printWithDividingLines("WAA??? Failed to save taskManager.getTasks() to disk?? The saver said: " + e.getMessage());
        }
    }
}
