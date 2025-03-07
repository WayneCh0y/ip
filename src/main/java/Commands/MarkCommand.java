package Commands;

import Managers.TaskManager;

/**
 * Represents a command to mark a task as done in the task manager.
 */
public class MarkCommand extends Command{
    private final String description;

    /**
     * Constructs a MarkCommand with the specified task description.
     *
     * @param description The description of the task to be marked as completed.
     */
    public MarkCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the mark command by marking the specified task in the task manager.
     */
    @Override
    public void execute() {
        TaskManager.mark(description);
    }
}
