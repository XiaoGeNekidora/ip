package litsewei;

import litsewei.exception.InvalidTaskFormatException;
import litsewei.exception.SaverException;
import litsewei.task.Deadline;
import litsewei.task.Event;
import litsewei.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class LitSewei {

    private Scanner sc = new Scanner(System.in);
    private TaskManager taskManager = new TaskManager();
    private CommandManager commandManager = new CommandManager(taskManager);


    private void mainLoop() {
        // Main loop
        while (sc.hasNext()) {
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else {
                commandManager.handleCommand(input);
            }
        }
    }

    private void loadFromDisk() {
        try {
            taskManager.loadFromDisk();
            Printer.printWithDividingLines("Recovered " + taskManager.getTasks().size() + " taskManager.getTasks() from my notebook for you~");

        } catch (SaverException e) {
            Printer.printWithDividingLines("WAA??? Failed to load taskManager.getTasks() from disk?? The saver said: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new LitSewei().start();
    }

    private void start() {
        Printer.printLogo();
        Printer.printGreeting();
        loadFromDisk();
        mainLoop();
        Printer.printGoodbye();
    }
}
