package TaskItems;

public class Deadline extends Task {
    protected String by;
    private final String TASK_TYPE = "[D]";

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
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
        return TASK_TYPE + super.toString() + " (by: " + by + ")";
    }
}
