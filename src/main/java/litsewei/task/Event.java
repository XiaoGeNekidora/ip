package litsewei.task;

import litsewei.exception.InvalidTaskFormatException;
import litsewei.util.MaybeDateTime;

/**
 * Represents an event task.
 */
public class Event extends Task {
    private MaybeDateTime start;
    private MaybeDateTime end;

    /**
     * Constructs an event task.
     * @param name the name of the event
     * @param start the start time of the event
     * @param end the end time of the event
     */
    public Event(String name, String start, String end) {
        super(name);
        this.start = new MaybeDateTime(start);
        this.end = new MaybeDateTime(end);
    }

    /**
     * Gets the start time of the event.
     * @return the start time
     */
    public MaybeDateTime getStart() {
        return start;
    }

    /**
     * Sets the start time of the event.
     * @param start the new start time
     */
    public void setStart(MaybeDateTime start) {
        this.start = start;
    }

    /**
     * Gets the end time of the event.
     * @return the end time
     */
    public MaybeDateTime getEnd() {
        return end;
    }

    /**
     * Sets the end time of the event.
     * @param end the new end time
     */
    public void setEnd(MaybeDateTime end) {
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
        return super.serialize() + "|" + start.serialize() + "|" + end.serialize();
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
