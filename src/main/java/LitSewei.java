import java.util.ArrayList;
import java.util.Scanner;

public class LitSewei {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Task> tasks = new ArrayList<>();

    private static void printDividingLine() {
        System.out.println("____________________________________________________________");
    }

    private static void printWithDividingLines(String message) {
        printDividingLine();
        System.out.println(message);
        printDividingLine();
    }

    private static void printGreeting() {
        printWithDividingLines("Hello! I'm Lit Sewei.\n" +
                "What can I do for you? UwU");
    }

    private static void printGoodbye() {
        printWithDividingLines("Bye. See you next time~~~");
    }

    private static void printList() {
        printDividingLine();
        System.out.println("Here is the TODO list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. [%s] %s\n", i + 1, tasks.get(i).isDone() ? "X" : " ", tasks.get(i).getName());
        }
        printDividingLine();
    }

    private static void markOrUnmark(String input, boolean mark) {
        try {
            int taskId = Integer.parseInt(input.split(" ")[1]);

            if (tasks.get(taskId - 1).isDone() == mark) {
                printWithDividingLines("Emm... This task is already " + (mark ? "marked" : "unmarked") + "? >_<");
                return;
            }

            tasks.get(taskId - 1).setDone(mark);

            if (mark) {
                printWithDividingLines("Marked this as done: " + tasks.get(taskId - 1).getName() + "!! :>");
            } else {
                printWithDividingLines("Marked this as not done yet: " + tasks.get(taskId - 1).getName() + "!! :<");
            }
        } catch (NumberFormatException e) {
            printWithDividingLines("I cannot understand >_<. Just give me an ID plz~");
        } catch (IndexOutOfBoundsException e) {
            printWithDividingLines("The ID you gave me seems wrong >_<. Plz check again~");
        }
    }

    public static void main(String[] args) {
        String logo = """
                .____    .__  __      _________                    .__\s
                |    |   |__|/  |_   /   _____/ ______  _  __ ____ |__|
                |    |   |  \\   __\\  \\_____  \\_/ __ \\ \\/ \\/ // __ \\|  |
                |    |___|  ||  |    /        \\  ___/\\     /\\  ___/|  |
                |_______ \\__||__|   /_______  /\\___  >\\/\\_/  \\___  >__|
                        \\/                  \\/     \\/            \\/   \s
                """;

        System.out.println("Hello from\n" + logo);
        printGreeting();

        // Main loop
        while (true) {
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                printList();
            } else if (input.startsWith("mark ")) {
                markOrUnmark(input, true);
            } else if (input.startsWith("unmark ")) {
                markOrUnmark(input, false);
            } else {
                tasks.add(new Task(input));

                printWithDividingLines("I've noted down this task: " + input + "!!!");
            }
        }

        printGoodbye();
    }
}
