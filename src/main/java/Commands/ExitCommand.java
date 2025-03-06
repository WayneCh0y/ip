package Commands;

import Managers.FileManager;
import Managers.Printer;
import Managers.TaskManager;

import java.io.IOException;

public class ExitCommand extends Command{
    @Override
    public void execute() throws IOException {
        Printer.end();
        FileManager.save(TaskManager.getTaskList());
    }

}
