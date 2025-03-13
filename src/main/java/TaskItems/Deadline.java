package TaskItems;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task with a deadline.
 * The Deadline task includes a description and a due date, stored as a {@code LocalDate}.
 */
public class Deadline extends Task {
    protected String by;
    private LocalDate date;

    private static final String TASK_TYPE = "[D]";
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy");

    /**
     * Constructs a Deadline task with the given description and due date.
     *
     * @param description The description of the task.
     * @param by The due date in {@code yyyy-MM-dd} format.
     * @throws IllegalArgumentException If the provided date is in an invalid format.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.date = parseDate(by);
    }

    /**
     * Parses the given date string into a {@code LocalDate} object.
     *
     * @param by The due date string in {@code yyyy-MM-dd} format.
     * @return A {@code LocalDate} object representing the due date.
     * @throws IllegalArgumentException If the date format is incorrect.
     */
    private LocalDate parseDate(String by) {
        try {
            return LocalDate.parse(by, INPUT_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns the task type identifier for a Deadline task.
     *
     * @return A string representing the task type, "[D]".
     */
    public String getTaskType() {
        return TASK_TYPE;
    }

    /**
     * Retrieves the description of the Deadline task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * Returns a formatted string representation of the Deadline task for saving to a file.
     *
     * @return A string containing the task description and due date.
     */
    public String getSaveDescription() {
        return getDescription() + "|" + this.by;
    }

    /**
     * Returns a formatted string representation of the Deadline task,
     * including its type, status, and formatted due date.
     *
     * @return A string representing the Deadline task.
     */
    @Override
    public String toString() {
        return TASK_TYPE + super.toString() + " (by: " + (date != null ? date.format(OUTPUT_FORMATTER) : by) + ")";
    }
}
