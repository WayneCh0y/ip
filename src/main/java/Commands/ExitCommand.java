package Commands;

import Managers.FileManager;
import Managers.Printer;
import Managers.TaskManager;

import java.io.IOException;

/**
 * Represents a command to terminate the program.
 * This command prints a farewell message and saves the current task list to a file.
 */
public class ExitCommand extends Command{
    /**
     * Executes the exit command by displaying a farewell message
     * and saving the current task list to the file.
     *
     * @throws IOException If an I/O error occurs while saving the tasks.
     */
    @Override
    public void execute() throws IOException {
        Printer.end();
        FileManager.save(TaskManager.getTaskList());
    }
}
