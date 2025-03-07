package Commands;

import java.io.IOException;

/**
 * Represents an abstract command that can be executed.
 * This serves as a base class for all specific command implementations.
 */
public abstract class Command {
    /**
     * Executes the command.
     * Concrete subclasses must provide their own implementation of this method.
     *
     * @throws IOException If an I/O error occurs during execution.
     */
    public abstract void execute() throws IOException;
}
