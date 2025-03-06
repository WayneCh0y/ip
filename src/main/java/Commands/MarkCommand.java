package Commands;

import Managers.TaskManager;

public class MarkCommand extends Command{
    private final String description;

    public MarkCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        TaskManager.mark(description);
    }
}
