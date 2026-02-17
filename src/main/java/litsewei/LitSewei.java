package litsewei;

import litsewei.exception.InvalidTaskFormatException;
import litsewei.task.Deadline;
import litsewei.task.Event;
import litsewei.task.Task;

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

    private static void printLogo() {
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
            System.out.printf("%d. %s\n", i + 1, tasks.get(i).toString());
        }
        printDividingLine();
    }

    private static void markOrUnmark(String input, boolean mark) {
        try {
            var list = input.split(" ");
            if (list.length == 1) {
                printWithDividingLines("Which? Please give me an ID...");
                return;
            }

            int taskId = Integer.parseInt(list[1]);

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

    private static void deleteTask(String input) {
        try {
            var list = input.split(" ");
            if (list.length == 1) {
                printWithDividingLines("Which? Please give me an ID...");
                return;
            }

            int taskId = Integer.parseInt(list[1]);

            var removedTask = tasks.remove(taskId - 1);

            printWithDividingLines("Deleted this: " + removedTask.getName() + "!! ^^");

        } catch (NumberFormatException e) {
            printWithDividingLines("I cannot understand >_<. Just give me an ID plz~");
        } catch (IndexOutOfBoundsException e) {
            printWithDividingLines("The ID you gave me seems wrong >_<. Plz check again~");
        }
    }

    private static void mainLoop() {
        // Main loop
        while (sc.hasNext()) {
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                printList();
            } else if (input.startsWith("mark")) {
                markOrUnmark(input, true);
            } else if (input.startsWith("unmark")) {
                markOrUnmark(input, false);
            } else if (input.startsWith("delete")) {
                deleteTask(input);
            } else if (input.startsWith("todo")) {
                addTodo(input);
            } else if (input.startsWith("deadline")) {
                addDeadline(input);
            } else if (input.startsWith("event")) {
                addEvent(input);
            } else {
                printWithDividingLines("I don't quite get it >_<. Can you rephrase?");
            }
        }
    }

    private static void addTodo(String input) {
        if (input.length() < 5) {
            printWithDividingLines("The description of a todo cannot be empty..?");
            return;
        }

        var task = new Task(input.substring(5));
        tasks.add(task);

        printWithDividingLines("I've noted down this todo: " + task.getName() + "!!!");
    }


    private static void addDeadline(String input) {
        try {
            if (input.length() < 9) {
                printWithDividingLines("The description of a deadline cannot be empty..?");
                return;
            }

            var ddl = Deadline.from(input.substring(9));
            tasks.add(ddl);

            printWithDividingLines("Remember to do " + ddl.getName() + " by " + ddl.getBy() + "!!!");
        } catch (InvalidTaskFormatException e) {
            printWithDividingLines("I could not understand that deadline format >_<. Please use: deadline <name> /by <due date>");
        }
    }

    private static void addEvent(String input) {
        try {
            if (input.length() < 6) {
                printWithDividingLines("The description of an event cannot be empty..?");
                return;
            }

            var event = Event.from(input.substring(6));
            tasks.add(event);

            printWithDividingLines(String.format("Noted the event: %s (from: %s to: %s)!!!",
                    event.getName(), event.getStart(), event.getEnd()));
        } catch (InvalidTaskFormatException e) {
            printWithDividingLines("I could not understand that event format >_<. Please use: event <name> /from <start time> /to <end time>");
        }
    }

    public static void main(String[] args) {
        printLogo();
        printGreeting();
        mainLoop();
        printGoodbye();
    }
}
