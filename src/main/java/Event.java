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
     * @param input input string including /from and /to
     * @throws IllegalArgumentException if input format is invalid
     */
    public static Event from(String input) {
        try {
            String[] parts = input.split(" /from | /to ");
            String name = parts[0].trim();
            String start = parts[1].trim();
            String end = parts[2].trim();
            return new Event(name, start, end);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "[E]" + (isDone() ? "[X] " : "[ ] ") + getName() + " (from: " + start + " to: " + end + ")";
    }
}
