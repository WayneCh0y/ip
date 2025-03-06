package Commands;

import Managers.TaskManager;

public class DeadlineCommand extends Command{
    private final String description;

    public DeadlineCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        TaskManager.deadline(description);
    }
}
