package Commands;

import Managers.TaskManager;

public class DeleteCommand extends Command{
    private final String description;

    public DeleteCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        TaskManager.delete(description);
    }
}
