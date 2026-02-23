package litsewei;

import litsewei.exception.InvalidTaskFormatException;
import litsewei.exception.SaverException;
import litsewei.task.Deadline;
import litsewei.task.Event;
import litsewei.task.Task;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTodo(String input) {
        if (input.length() < 5) {
            Printer.printWithDividingLines("The description of a todo cannot be empty..?");
            return;
        }

        var task = new Task(input.substring(5));
        tasks.add(task);

        Printer.printWithDividingLines("I've noted down this todo: " + task.getName() + "!!!");
    }


    public void addDeadline(String input) {
        try {
            if (input.length() < 9) {
                Printer.printWithDividingLines("The description of a deadline cannot be empty..?");
                return;
            }

            var ddl = Deadline.from(input.substring(9));
            tasks.add(ddl);

            Printer.printWithDividingLines("Remember to do " + ddl.getName() + " by " + ddl.getBy() + "!!!");
        } catch (InvalidTaskFormatException e) {
            Printer.printWithDividingLines("I could not understand that deadline format >_<. Please use: deadline <name> /by <due date>");
        }
    }

    public void addEvent(String input) {
        try {
            if (input.length() < 6) {
                Printer.printWithDividingLines("The description of an event cannot be empty..?");
                return;
            }

            var event = Event.from(input.substring(6));
            tasks.add(event);

            Printer.printWithDividingLines(String.format("Noted the event: %s (from: %s to: %s)!!!",
                    event.getName(), event.getStart(), event.getEnd()));
        } catch (InvalidTaskFormatException e) {
            Printer.printWithDividingLines("I could not understand that event format >_<. Please use: event <name> /from <start time> /to <end time>");
        }
    }

    public void deleteTask(String input) {
        try {
            var list = input.split(" ");
            if (list.length == 1) {
                Printer.printWithDividingLines("Which? Please give me an ID...");
                return;
            }

            int taskId = Integer.parseInt(list[1]);

            var removedTask = tasks.remove(taskId - 1);

            Printer.printWithDividingLines("Deleted this: " + removedTask.getName() + "!! ^^");

        } catch (NumberFormatException e) {
            Printer.printWithDividingLines("I cannot understand >_<. Just give me an ID plz~");
        } catch (IndexOutOfBoundsException e) {
            Printer.printWithDividingLines("The ID you gave me seems wrong >_<. Plz check again~");
        }
    }


    /**
     * Loads the list of taskManager.getTasks() from disk and assigns it to the taskManager.getTasks() variable. <br/>
     */
    public void loadFromDisk() {
        try {
            tasks = Saver.load();
            Printer.printWithDividingLines("Recovered " + tasks.size() + " taskManager.getTasks() from my notebook for you~");
        } catch (SaverException e) {
            Printer.printWithDividingLines("EHH??? Failed to load taskManager.getTasks() from disk?? My messenger said: " + e.getMessage());
        }
    }

    /**
     * Saves the current list of taskManager.getTasks() to disk. If there is an error during saving, an error message will be printed. <br/>
     */
    public void saveToDisk() {
        try {
            Saver.save(tasks);
            Printer.printWithDividingLines("Saved successfully!!!");
        } catch (SaverException e) {
            Printer.printWithDividingLines("WAA??? Failed to save taskManager.getTasks() to disk?? The saver said: " + e.getMessage());
        }
    }
}
