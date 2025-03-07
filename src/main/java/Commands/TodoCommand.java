package Commands;

import Managers.TaskManager;

/**
 * Represents a command to add a Todo task to the task manager.
 */
public class TodoCommand extends Command{
    private final String description;

    /**
     * Constructs a TodoCommand with the specified task description.
     *
     * @param description The description of the Todo task to be added.
     */
    public TodoCommand(String description) {
        this.description = description;
    }
    /**
     * Executes the command by adding the Todo task to the task manager.
     */
    @Override
    public void execute() {
        TaskManager.todo(description);
    }
}
