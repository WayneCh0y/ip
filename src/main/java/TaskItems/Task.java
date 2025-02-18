package TaskItems;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;

    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    public boolean getStatus() {
        return isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String getDescription() {
      return this.description;
    }

    public String getSaveDescription() {
        return getDescription();
    }

    public String getTaskType() {
        return this.taskType;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
