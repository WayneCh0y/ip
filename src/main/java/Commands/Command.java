package Commands;

import java.io.IOException;

public abstract class Command {
    public abstract void execute() throws IOException;
}
