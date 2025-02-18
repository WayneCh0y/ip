package TaskItems;

public class Event extends Task {
    private String startTime;
    private String endTime;
    private final String TASK_TYPE = "[E]";

    public Event(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTaskType() {
        return TASK_TYPE;
    }

    public String getDescription() {
        return super.getDescription();
    }

    public String getSaveDescription() {
        return getDescription() + "|" + this.startTime + "|" + this.endTime;
    }

    @Override
    public String toString() {
        return TASK_TYPE + super.toString() + " (from: " + startTime + " to: " + endTime + ")";
    }
}
