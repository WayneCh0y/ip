package Commands;

import Managers.TaskManager;

public class FindCommand extends Command{
    private final String description;

    public FindCommand(String description) {
        this.description = description;
    }
    @Override
    public void execute() {
        TaskManager.find(description);
    }
}
