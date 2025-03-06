package TaskItems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    protected String by;
    private LocalDate date;

    private static final String TASK_TYPE = "[D]";
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy");

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.date = parseDate(by);
    }

    private LocalDate parseDate(String by) {
        try {
            return LocalDate.parse(by, INPUT_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException();
        }
    }

    public String getTaskType() {
        return TASK_TYPE;
    }

    public String getDescription() {
        return super.getDescription();
    }

    public String getSaveDescription() {
        return getDescription() + "|" + this.by;
    }

    @Override
    public String toString() {
        return TASK_TYPE + super.toString() + " (by: " + date.format(OUTPUT_FORMATTER) + ")";
    }
}
