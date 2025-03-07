package Commands;

import Managers.TaskManager;

/**
 * Represents a command to unmark a task.
 */
public class UnmarkCommand extends Command{
    private final String description;

    /**
     * Constructs an UnmarkCommand with the specified task description.
     *
     * @param description The description of the task to be unmarked.
     */
    public UnmarkCommand(String description) {
        this.description = description;
    }


    /**
     * Executes the command by unmarking the specified task.
     */
    @Override
    public void execute() {
        TaskManager.unmark(description);
    }
}
