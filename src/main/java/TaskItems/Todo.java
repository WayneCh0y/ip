package TaskItems;

/**
 * Represents a Todo task, which is a simple task without a specific deadline or time frame.
 * This class extends the Task class and includes a task type identifier.
 */
public class Todo extends Task {
    private final String TASK_TYPE = "[T]";

    /**
     * Constructs a Todo task with the given description.
     *
     * @param description The description of the task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the task type identifier for a Todo task.
     *
     * @return A string representing the task type, "[T]".
     */
    public String getTaskType() {
        return TASK_TYPE;
    }

    /**
     * Retrieves the description of the Todo task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * Returns the description of the Todo task in a specific format for saving purposes.
     *
     * @return The task description.
     */
    public String getSaveDescription() {
        return getDescription();
    }

    /**
     * Returns a string representation of the Todo task, including its task type.
     *
     * @return A formatted string representing the Todo task.
     */
    @Override
    public String toString() {
        return TASK_TYPE + super.toString();
    }
}
