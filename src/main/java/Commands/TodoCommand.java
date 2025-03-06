package Commands;

import Managers.TaskManager;

public class TodoCommand extends Command{
    private final String description;

    public TodoCommand(String description) {
        this.description = description;
    }
    @Override
    public void execute() {
        TaskManager.todo(description);
    }
}
