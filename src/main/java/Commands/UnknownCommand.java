package Commands;

import Managers.Printer;

public class UnknownCommand extends Command{
    @Override
    public void execute() {
        Printer.printUnknownCommandMessage();
    }
}
