package Commands;

import Managers.TaskManager;
/**
 * A command that generates and prints a random fun fact about Gojo.
 */
public class GojoCommand extends Command{
    /**
     * Executes the command by retrieving and displaying a fun fact about Gojo.
     */
    @Override
    public void execute() {
        TaskManager.funFact();
    }
}
