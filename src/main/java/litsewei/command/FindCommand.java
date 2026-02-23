package litsewei.command;

import litsewei.Printer;
import litsewei.TaskManager;
import litsewei.task.Task;
import litsewei.util.Pair;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindCommand extends Command {


    @Override
    public boolean isTriggered(String input) {
        return input.startsWith("find");
    }

    @Override
    public void execute(String input, TaskManager taskManager) {
        var filter = input.substring("find".length()).trim();

        if(filter.isBlank()) {
            Printer.printWithDividingLines("Please provide a keyword to search for!~");
            return;
        }

        var list = IntStream.range(0, taskManager.getTasks().size())
                .mapToObj(i -> new Pair<>(i, taskManager.getTasks().get(i)))
                .filter(e -> e.item.getName().contains(filter))
                .collect(Collectors.toCollection(ArrayList::new));
        Printer.printPairedList(list);
    }
}
