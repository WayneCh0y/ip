package Commands;

import Managers.TaskManager;

/**
 * Represents a command to list all tasks stored in the task manager.
 */
public class ListCommand extends Command{
    /**
     * Executes the list command by displaying all tasks currently in the task manager.
     */
    @Override
    public void execute() {
        TaskManager.printTaskList();
    }
}
