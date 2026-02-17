package litsewei.task;

import litsewei.exception.InvalidTaskFormatException;

import java.util.Scanner;

public class Event extends Task {
    private String start;
    private String end;

    public Event(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Create Event from input string
     *
     * @param input input string including /from and /to
     * @throws InvalidTaskFormatException if input format is invalid
     */
    public static Event from(String input) {
        try {
            String[] parts = input.split(" /from | /to ");
            String name = parts[0].trim();
            String start = parts[1].trim();
            String end = parts[2].trim();
            return new Event(name, start, end);
        } catch (Exception e) {
            throw new InvalidTaskFormatException();
        }
    }

    /**
     * Create Event from a serialized string. <br/>
     * The format should be "type|name|isDone|start|end"
     *
     * @return The task created from the serialized string
     */
    public static Event fromSerialized(String serializedString) {
        var split = serializedString.split("\\|");
        String name = split[1].trim();
        boolean isDone = split[2].trim().equals("true");
        String start = split[3].trim();
        String end = split[4].trim();
        Event event = new Event(name, start, end);
        event.setDone(isDone);
        return event;
    }

    @Override
    public String serialize() {
        return super.serialize() + "|" + start + "|" + end;
    }


    @Override
    public String getTaskType() {
        return "E";
    }


    @Override
    public String toString() {
        return super.toString() + " (from: " + start + " to: " + end + ")";
    }
}
