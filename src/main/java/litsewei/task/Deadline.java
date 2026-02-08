package litsewei.task;

import litsewei.exception.InvalidTaskFormatException;

public class Deadline extends Task {
    private String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    /**
     * Create DDL from input string
     *
     * @param input input string including /from and /to
     * @throws InvalidTaskFormatException if input format is invalid
     */
    public static Deadline from(String input) {
        try {
            String[] parts = input.split(" /by ");
            String name = parts[0].trim();
            String by = parts[1].trim();
            return new Deadline(name, by);
        } catch (Exception ex) {
            throw new InvalidTaskFormatException();
        }
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }
}
