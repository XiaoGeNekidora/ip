package litsewei;

import litsewei.exception.SaverException;
import litsewei.task.Deadline;
import litsewei.task.Event;
import litsewei.task.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles saving and loading of tasks to and from a file. <br/>
 * File path is at "data/tasks.txt". <br/>
 * If the file or directory does not exist, it will be created when saving. <br
 */
public class Saver {
    /**
     * Saves the list of tasks to a file. <br/>
     * @param tasks - the list of tasks to save
     * @throws SaverException if there is an error during saving, such as IO exceptions or directory creation failures.
     */
    public static void save(ArrayList<Task> tasks) throws SaverException {
        var dir = new File("data");
        if (!dir.exists()) {
            boolean success=dir.mkdir();
            if(!success){
                throw new SaverException("Failed to create data directory.");
            }
        }

        var file = new File("data/tasks.txt");
        try(var writer = new BufferedWriter(new FileWriter(file))){
            for(Task task: tasks){
                writer.write(task.serialize());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new SaverException("IO Exception:"+e.getMessage());
        }
    }

    /**
     * Loads the list of tasks from a file. <br/>
     * @return the list of tasks loaded from the file. If the file does not exist, an empty list is returned.
     * @throws SaverException if there is an error during loading, such as IO exceptions or unknown task types in the file.
     */
    public static ArrayList<Task> load() throws SaverException {
        var file = new File("data/tasks.txt");
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (var reader = new java.util.Scanner(file)) {
            ArrayList<Task> tasks = new ArrayList<>();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String type = line.split("\\|")[0].trim();
                switch (type) {
                    case "T":
                        tasks.add(Task.fromSerialized(line));
                        break;
                    case "D":
                        tasks.add(Deadline.fromSerialized(line));
                        break;
                    case "E":
                        tasks.add(Event.fromSerialized(line));
                        break;
                    default:
                        throw new SaverException("Unknown task type in file: " + type);
                }
            }
            return tasks;
        } catch (IOException e) {
            throw new SaverException("IO Exception:"+e.getMessage());
        }
    }

}
