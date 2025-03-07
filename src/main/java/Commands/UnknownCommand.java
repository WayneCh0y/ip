package Commands;

import Managers.Printer;

/**
 * Represents a command that is unrecognized by the system.
 * Executes by printing an error message to notify the user.
 */
public class UnknownCommand extends Command{
    /**
     * Executes the command by displaying an unknown command message.
     */
    @Override
    public void execute() {
        Printer.printUnknownCommandMessage();
    }
}
