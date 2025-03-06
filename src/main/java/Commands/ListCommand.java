package Commands;

import Managers.TaskManager;

public class ListCommand extends Command{
    @Override
    public void execute() {
        TaskManager.printTaskList();
    }
}
