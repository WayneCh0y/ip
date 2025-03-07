package TaskItems;

/**
 * Represents a task with a description and completion status.
 * This is the base class for the different types of tasks (e.g., Todo, Deadline, Event).
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;

    /**
     * Constructs a new Task with the given description.
     * the task is not completed initially.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    /**
     * Returns the completion status of the task.
     *
     * @return {@code true} if the task is completed, {@code false} otherwise.
     */
    public boolean getStatus() {
        return isDone;
    }

    /**
     * Returns the status icon of the task.
     * "X" represents a completed task, while empty represents an incomplete task.
     *
     * @return A string representing the status of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Returns the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
      return this.description;
    }

    /**
     * Returns the description in a specific format to be saved in a file.
     *
     * @return The string representation of the task in the specified format for saving.
     */
    public String getSaveDescription() {
        return getDescription();
    }

    /**
     * Returns the type of the task.
     *
     * @return The task type as a string.
     */
    public String getTaskType() {
        return this.taskType;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Unmarks the task.
     */
    public void unmarkAsDone() {
        this.isDone = false;
    }

    /**
     * Returns a basic string representation of the task, including its completion status.
     *
     * @return The formatted task string.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
