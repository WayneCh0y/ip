package Commands;

import Managers.TaskManager;

public class EventCommand extends Command{
    private final String description;

    public EventCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        TaskManager.event(description);
    }
}
