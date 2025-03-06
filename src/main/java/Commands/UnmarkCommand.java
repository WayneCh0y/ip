package Commands;

import Managers.TaskManager;

public class UnmarkCommand extends Command{
    private final String description;

    public UnmarkCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        TaskManager.unmark(description);
    }
}
