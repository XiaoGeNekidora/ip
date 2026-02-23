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


    public static void main(String[] args) {
        new LitSewei().start();
    }

    private void start() {
        Printer.printLogo();
        Printer.printGreeting();
        taskManager.loadFromDisk();
        mainLoop();
        Printer.printGoodbye();
    }
}
