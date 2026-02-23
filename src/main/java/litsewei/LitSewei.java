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


    private void markOrUnmark(String input, boolean mark) {
        try {
            var list = input.split(" ");
            if (list.length == 1) {
                Printer.printWithDividingLines("Which? Please give me an ID...");
                return;
            }

            int taskId = Integer.parseInt(list[1]);

            if (taskManager.getTasks().get(taskId - 1).isDone() == mark) {
                Printer.printWithDividingLines("Emm... This task is already " + (mark ? "marked" : "unmarked") + "? >_<");
                return;
            }

            taskManager.getTasks().get(taskId - 1).setDone(mark);

            if (mark) {
                Printer.printWithDividingLines("Marked this as done: " + taskManager.getTasks().get(taskId - 1).getName() + "!! :>");
            } else {
                Printer.printWithDividingLines("Marked this as not done yet: " + taskManager.getTasks().get(taskId - 1).getName() + "!! :<");
            }
        } catch (NumberFormatException e) {
            Printer.printWithDividingLines("I cannot understand >_<. Just give me an ID plz~");
        } catch (IndexOutOfBoundsException e) {
            Printer.printWithDividingLines("The ID you gave me seems wrong >_<. Plz check again~");
        }
    }



    private void mainLoop() {
        // Main loop
        while (sc.hasNext()) {
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                Printer.printList(taskManager.getTasks());
            } else if (input.startsWith("mark")) {
                markOrUnmark(input, true);
            } else if (input.startsWith("unmark")) {
                markOrUnmark(input, false);
            } else if (input.startsWith("delete")) {
                taskManager.deleteTask(input);
            } else if (input.startsWith("todo")) {
                taskManager.addTodo(input);
            } else if (input.startsWith("deadline")) {
                taskManager.addDeadline(input);
            } else if (input.startsWith("event")) {
                taskManager.addEvent(input);
            } else if (input.equalsIgnoreCase("save")) {
                taskManager.saveToDisk();
            } else {
                Printer.printWithDividingLines("I don't quite get it >_<. Can you rephrase?");
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
