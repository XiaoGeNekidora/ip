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
 * This class handles saving and loading of tasks to and from a file. <br/>
 */
public class Saver {
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
