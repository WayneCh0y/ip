package TaskItems;

/**
 * Represents an event task with a start time and an end time.
 * The Event task includes a description and the time range during which the event occurs.
 */
public class Event extends Task {
    private String startTime;
    private String endTime;
    private final String TASK_TYPE = "[E]";

    /**
     * Constructs an Event task with the given description, start time, and end time.
     *
     * @param description The description of the event.
     * @param startTime The start time of the event.
     * @param endTime The end time of the event.
     */
    public Event(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the task type identifier for an Event task.
     *
     * @return A string representing the task type, "[E]".
     */
    public String getTaskType() {
        return TASK_TYPE;
    }

    /**
     * Retrieves the description of the Event task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * Returns a formatted string representation of the Event task for saving to a file.
     *
     * @return A string containing the task description, start time, and end time.
     */
    public String getSaveDescription() {
        return getDescription() + "|" + this.startTime + "|" + this.endTime;
    }

    /**
     * Returns a formatted string representation of the Event task,
     * including its type, status, start time, and end time.
     *
     * @return A string representing the Event task.
     */
    @Override
    public String toString() {
        return TASK_TYPE + super.toString() + " (from: " + startTime + " to: " + endTime + ")";
    }
}
