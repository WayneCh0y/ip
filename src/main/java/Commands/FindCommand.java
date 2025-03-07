package Commands;

import Managers.TaskManager;

/**
 * Represents a command to find tasks that match a given keyword.
 */
public class FindCommand extends Command{
    private final String description;

    /**
     * Constructs a FindCommand with the specified search keyword.
     *
     * @param description The keyword used to search for matching tasks.
     */
    public FindCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command by searching for tasks that contain the given keyword.
     */
    @Override
    public void execute() {
        TaskManager.find(description);
    }
}
