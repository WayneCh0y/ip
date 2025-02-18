package TaskItems;

public class Todo extends Task {
    private final String TASK_TYPE = "[T]";

    public Todo(String description) {
        super(description);
    }

    public String getTaskType() {
        return TASK_TYPE;
    }

    public String getDescription() {
        return super.getDescription();
    }

    public String getSaveDescription() {
        return getDescription();
    }

    @Override
    public String toString() {
        return TASK_TYPE + super.toString();
    }
}
