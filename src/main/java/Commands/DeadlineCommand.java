package Commands;

import Managers.TaskManager;

/**
 * Represents a command to create a new Deadline task and add it to the TaskManager.
 */
public class DeadlineCommand extends Command{
    private final String description;

    /**
     * Constructs a DeadlineCommand with the specified task description.
     *
     * @param description The description of the deadline task.
     */
    public DeadlineCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command by adding a Deadline task to the TaskManager.
     */
    @Override
    public void execute() {
        TaskManager.deadline(description);
    }
}
