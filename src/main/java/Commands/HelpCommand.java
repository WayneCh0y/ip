package Commands;


import Managers.TaskManager;

/**
 * A command that displays a list of available commands and their usage.
 */
public class HelpCommand extends Command{
    /**
     * Executes the command by displaying the help menu with available commands.
     */
    @Override
    public void execute() {
        TaskManager.help();
    }
}
