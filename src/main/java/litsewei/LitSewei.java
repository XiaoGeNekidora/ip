package litsewei;

import litsewei.exception.SaverException;

import java.util.Scanner;

/**
 * Main class for the LitSewei chatbot.
 */
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
            Printer.printWithDividingLines("Recovered " + taskManager.getTasks().size() + " tasks from my notebook for you~");

        } catch (SaverException e) {
            Printer.printWithDividingLines("WAA??? Failed to load taskManager.getTasks() from disk?? The saver said: " + e.getMessage());
        }
    }

    /**
     * Main entry point of the application.
     * @param args command line arguments
     */
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
