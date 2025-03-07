package Commands;

import Managers.TaskManager;

/**
 * Represents a command to add an event task to the TaskManager.
 */
public class EventCommand extends Command{
    private final String description;

    /**
     * Constructs an EventCommand with the specified event description.
     *
     * @param description The details of the event task, including its description, start, and end times.
     */
    public EventCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command by adding an event task to the TaskManager.
     */
    @Override
    public void execute() {
        TaskManager.event(description);
    }
}
