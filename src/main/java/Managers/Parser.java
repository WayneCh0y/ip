package Managers;

import Commands.Command;
import Commands.DeadlineCommand;
import Commands.DeleteCommand;
import Commands.EventCommand;
import Commands.ExitCommand;
import Commands.FindCommand;
import Commands.ListCommand;
import Commands.MarkCommand;
import Commands.TodoCommand;
import Commands.UnknownCommand;
import Commands.UnmarkCommand;
import Managers.Exceptions.IllegalCommandException;

public class Parser {
    private static final int TASK_TYPE_INDEX = 0;
    private static final int TASK_COMMAND_INDEX = 1;

    private static final String SPACE_REGEX = " ";
    private static final String DEADLINE_BY_REGEX = "\\s*/by\\s*";
    private static final String EVENT_FROM_TO_REGEX = "\\s*/from\\s*|\\s*/to\\s*";

    private static final int SPLIT_SUBSTRINGS = 2;

    private static final int MIN_DEADLINE_COMMAND_LENGTH = 2;
    private static final int MIN_EVENT_COMMAND_LENGTH = 3;

    private static final int NUMBER_TO_INDEX_OFFSET = 1;
    private static final int MINIMUM_LIST_SIZE = 0;

    private static final String CASE_BYE = "bye";
    private static final String CASE_LIST = "list";
    private static final String CASE_TODO = "todo";
    private static final String CASE_DEADLINE = "deadline";
    private static final String CASE_EVENT = "event";
    private static final String CASE_MARK = "mark";
    private static final String CASE_UNMARK = "unmark";
    private static final String CASE_DELETE = "delete";
    private static final String CASE_FIND = "find";

    public static String getTaskType(String command) {
        return (command.split(SPACE_REGEX, SPLIT_SUBSTRINGS))[TASK_TYPE_INDEX];
    }

    public static String getTodo(String command) {
        return command.split(SPACE_REGEX, SPLIT_SUBSTRINGS)[TASK_COMMAND_INDEX];
    }

    public static String[] getDeadline(String command) throws IllegalCommandException {
        String[] split = command.split(SPACE_REGEX, SPLIT_SUBSTRINGS);

        if (split.length < SPLIT_SUBSTRINGS) {
            throw new IllegalCommandException();
        }

        String deadlineCommand = split[TASK_COMMAND_INDEX];
        String[] deadlineTask = deadlineCommand.split(DEADLINE_BY_REGEX);

        if (deadlineTask.length < MIN_DEADLINE_COMMAND_LENGTH) {
            throw new IndexOutOfBoundsException();
        }

        return deadlineTask;
    }

    public static String[] getEvent(String command) throws IllegalCommandException {
        String[] split = command.split(SPACE_REGEX, SPLIT_SUBSTRINGS);

        if (split.length < SPLIT_SUBSTRINGS) {
            throw new IllegalCommandException();
        }

        String eventCommand = split[TASK_COMMAND_INDEX];
        String[] eventTask = eventCommand.split(EVENT_FROM_TO_REGEX);

        if (eventTask.length < MIN_EVENT_COMMAND_LENGTH) {
            throw new IndexOutOfBoundsException();
        }

        return eventTask;
    }

    public static int getNumberToMark(String command) throws IllegalCommandException {
        String[] split = command.split(SPACE_REGEX, SPLIT_SUBSTRINGS);

        if (split.length < SPLIT_SUBSTRINGS) {
            throw new IllegalCommandException();
        }
        int numberToMark;
        try {
            numberToMark = Integer.parseInt(split[TASK_COMMAND_INDEX]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        int indexToMark = numberToMark - NUMBER_TO_INDEX_OFFSET;
        if (numberToMark > TaskManager.getListSize() || numberToMark <= MINIMUM_LIST_SIZE) {
            throw new IndexOutOfBoundsException();
        }
        if (TaskManager.getIndexStatus(indexToMark)) {
            throw new Error();
        }
        return indexToMark;
    }

    public static int getNumberToUnmark(String command) throws IllegalCommandException {
        String[] split = command.split(SPACE_REGEX, SPLIT_SUBSTRINGS);

        if (split.length < SPLIT_SUBSTRINGS) {
            throw new IllegalCommandException();
        }
        int numberToUnmark;
        try {
            numberToUnmark = Integer.parseInt(split[TASK_COMMAND_INDEX]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        int indexToUnmark = numberToUnmark - NUMBER_TO_INDEX_OFFSET;
        if (numberToUnmark > TaskManager.getListSize() || numberToUnmark <= MINIMUM_LIST_SIZE) {
            throw new IndexOutOfBoundsException();
        }
        if (!TaskManager.getIndexStatus(indexToUnmark)) {
            throw new Error();
        }
        return indexToUnmark;
    }

    public static int getNumberToDelete(String command) throws IllegalCommandException {
        String[] split = command.split(SPACE_REGEX, SPLIT_SUBSTRINGS);

        if (split.length < SPLIT_SUBSTRINGS) {
            throw new IllegalCommandException();
        }

        int numberToDelete;

        try {
            numberToDelete = Integer.parseInt(split[TASK_COMMAND_INDEX]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        if (numberToDelete > TaskManager.getListSize() || numberToDelete <= MINIMUM_LIST_SIZE) {
            throw new IndexOutOfBoundsException();
        }

        return numberToDelete - NUMBER_TO_INDEX_OFFSET;
    }

    public static String getKeyword(String command) {
        return command.split(SPACE_REGEX, SPLIT_SUBSTRINGS)[TASK_COMMAND_INDEX];
    }

    public static Command parseCommand(String input) {
        String taskType = getTaskType(input);
        switch (taskType) {
        case CASE_BYE:
            return new ExitCommand();
        case CASE_LIST:
            return new ListCommand();
        case CASE_TODO:
            return new TodoCommand(input);
        case CASE_DEADLINE:
            return new DeadlineCommand(input);
        case CASE_EVENT:
            return new EventCommand(input);
        case CASE_MARK:
            return new MarkCommand(input);
        case CASE_UNMARK:
            return new UnmarkCommand(input);
        case CASE_DELETE:
            return new DeleteCommand(input);
        case CASE_FIND:
            return new FindCommand(input);
        default:
            return new UnknownCommand();
        }
    }
}
