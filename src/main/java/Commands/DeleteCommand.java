package Commands;

import Managers.TaskManager;

/**
 * Represents a command to delete a task from the TaskManager.
 */
public class DeleteCommand extends Command{
    private final String description;

    /**
     * Constructs a DeleteCommand with the specified task description or index.
     *
     * @param description The description or index of the task to be deleted.
     */
    public DeleteCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command by deleting the specified task from the TaskManager.
     */
    @Override
    public void execute() {
        TaskManager.delete(description);
    }
}
