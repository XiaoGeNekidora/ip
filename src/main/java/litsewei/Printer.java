package litsewei;

import litsewei.task.Task;
import litsewei.util.Pair;

import java.util.ArrayList;

/**
 * A utility class to print messages to the user. <br/>
 */
public class Printer {
    /**
     * Prints a dividing line to the console.
     */
    public static void printDividingLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Prints a message to the console, enclosed by dividing lines.
     * @param message the message to print
     */
    public static void printWithDividingLines(String message) {
        printDividingLine();
        System.out.println(message);
        printDividingLine();
    }

    /**
     * Prints the logo of the application.
     */
    public static void printLogo() {
        String logo = """
                .____    .__  __      _________                    .__
                |    |   |__|/  |_   /   _____/ ______  _  __ ____ |__|
                |    |   |  \\   __\\  \\_____  \\_/ __ \\ \\/ \\/ // __ \\|  |
                |    |___|  ||  |    /        \\  ___/\\     /\\  ___/|  |
                |_______ \\__||__|   /_______  /\\___  >\\/\\_/  \\___  >__|
                        \\/                  \\/     \\/            \\/
                """;

        System.out.println("Hello from\n" + logo);
    }

    /**
     * Prints the greeting message.
     */
    public static void printGreeting() {
        printWithDividingLines("Hello! I'm Lit Sewei.\n" +
                "What can I do for you? UwU");
    }

    /**
     * Prints the goodbye message.
     */
    public static void printGoodbye() {
        printWithDividingLines("Bye. See you next time~~~");
    }

    /**
     * Prints the list of tasks.
     * @param tasks the list of tasks to print
     */
    public static void printList(ArrayList<Task> tasks) {
        printDividingLine();
        System.out.println("Here is the TODO list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, tasks.get(i).toString());
        }
        printDividingLine();
    }

    /**
     * Prints a filtered list of tasks.
     * @param tasks the list of tasks (paired with original index) to print
     */
    public static void printPairedList(ArrayList<Pair<Task>> tasks) {
        printDividingLine();
        System.out.println("Here is the filtered TODO list:");
        for (var item : tasks) {
            System.out.printf("%d. %s\n", item.index + 1, item.item.toString());
        }
        printDividingLine();
    }
}
