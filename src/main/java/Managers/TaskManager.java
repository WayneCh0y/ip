package Managers;

import Managers.Exceptions.IllegalCommandException;
import TaskItems.Deadline;
import TaskItems.Event;
import TaskItems.Task;
import TaskItems.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Manages a list of tasks, providing functionalities to add, remove, and modify tasks.
 */
public class TaskManager {
    private static List<Task> taskList;

    private static final int TASK_DESCRIPTION_INDEX = 0;
    private static final int DEADLINE_BY_INDEX = 1;
    private static final int EVENT_FROM_INDEX = 1;
    private static final int EVENT_TO_INDEX = 2;

    private static final int ILLEGAL_COMMAND_INDEX = 0;
    private static final int OUT_OF_BOUNDS_INDEX = 1;
    private static final int ILLEGAL_ARGUMENT_INDEX = 2;
    private static final int ERROR_INDEX = 3;
    private static final int RUNTIME_EXCEPTION_INDEX = 4;

    private static final String[] FUN_FACTS = {
            "Gojo Satoru is the first sorcerer in 400 years to inherit both the Six Eyes and Limitless.",
            "His favorite food is sweets, especially mochi and desserts!",
            "Gojo wears a blindfold or dark sunglasses to manage the overwhelming power of the Six Eyes.",
            "He considers himself 'the strongest' - and he's not wrong!",
            "Despite his carefree attitude, Gojo deeply cares for his students and wants to reform the Jujutsu world.",
            "Gojo's Infinity ability makes him untouchable by normal means.",
            "His Domain Expansion, Unlimited Void, overwhelms opponents by flooding them with infinite information.",
            "He has an insane sense of fashion and is often seen wearing trendy clothes.",
            "Gojo is a fan of Digimon",
    };

    /**
     * Constructs a new TaskManager with an empty task list.
     */
    public TaskManager() {
        taskList = new ArrayList<>();
    }

    /**
     * Retrieves the number of tasks currently in the list.
     *
     * @return The size of the task list.
     */
    public static int getListSize() {
        return taskList.size();
    }

    /**
     * Retrieves the list of tasks.
     *
     * @return The list of tasks.
     */
    public static List<Task> getTaskList() {
        return taskList;
    }

    /**
     * Prints all tasks currently in the list.
     */
    public static void printTaskList() {
        Printer.printTaskList(taskList);
    }

    /**
     * Retrieves the completion status of a task at a specified index.
     *
     * @param index The index of the task.
     * @return {@code true} if the task is marked as done, {@code false} otherwise.
     */
    public static boolean getIndexStatus(int index) {
        return taskList.get(index).getStatus();
    }

    /**
     * Adds a new Todo task to the list.
     * If the command contains an empty description, an error message is printed.
     *
     * @param command The user input command.
     */
    public static void todo(String command) {
        try {
            if (Parser.getTodo(command).trim().isEmpty()) {
                Printer.printEmptyCommandMessage();
                return;
            }

            Task task = new Todo(Parser.getTodo(command));
            taskList.add(task);
            Printer.printTaskAdded(getListSize(), task);
        } catch (IndexOutOfBoundsException e) {
            Printer.printTodoExceptionMessage();
        }
    }

    /**
     * Adds a new Deadline task to the list.
     * If the command contains an empty description, an error message is printed.
     *
     * @param command The user input command containing the task description and deadline.
     */
    public static void deadline(String command) {
        try {
            if (Parser.getDeadline(command)[TASK_DESCRIPTION_INDEX].trim().isEmpty()) {
                Printer.printEmptyCommandMessage();
                return;
            }
            if (Parser.getDeadline(command)[DEADLINE_BY_INDEX].trim().isEmpty()) {
                Printer.printEmptyCommandMessage();
                return;
            }

            String[] deadlineSpecifics = Parser.getDeadline(command);
            Task deadlineTask = new Deadline(deadlineSpecifics[TASK_DESCRIPTION_INDEX],
                    deadlineSpecifics[DEADLINE_BY_INDEX]);
            taskList.add(deadlineTask);
            Printer.printTaskAdded(getListSize(), deadlineTask);
        } catch (IllegalCommandException e) {
            Printer.printDeadlineExceptionMessage(ILLEGAL_COMMAND_INDEX);
        } catch (IndexOutOfBoundsException e) {
            Printer.printDeadlineExceptionMessage(OUT_OF_BOUNDS_INDEX);
        } catch (IllegalArgumentException e) {
            Printer.printDeadlineExceptionMessage(ILLEGAL_ARGUMENT_INDEX);
        }
    }

    /**
     * Adds a new Event task to the list.
     * If the command contains an empty description, an error message is printed.
     *
     * @param command The user input command containing the task description and event timeline.
     */
    public static void event(String command) {
        try {
            if (Parser.getEvent(command)[TASK_DESCRIPTION_INDEX].trim().isEmpty()) {
                Printer.printEmptyCommandMessage();
                return;
            }
            if (Parser.getEvent(command)[EVENT_FROM_INDEX].trim().isEmpty()) {
                Printer.printEmptyCommandMessage();
                return;
            }
            if (Parser.getEvent(command)[EVENT_TO_INDEX].trim().isEmpty()) {
                Printer.printEmptyCommandMessage();
                return;
            }

            String[] eventSpecifics = Parser.getEvent(command);
            Task eventTask = new Event(eventSpecifics[TASK_DESCRIPTION_INDEX],
                    eventSpecifics[EVENT_FROM_INDEX], eventSpecifics[EVENT_TO_INDEX]);
            taskList.add(eventTask);
            Printer.printTaskAdded(getListSize(), eventTask);
        } catch (IllegalCommandException e) {
            Printer.printEventExceptionMessage(ILLEGAL_COMMAND_INDEX);
        } catch (IndexOutOfBoundsException e) {
            Printer.printEventExceptionMessage(OUT_OF_BOUNDS_INDEX);
        }
    }

    /**
     * Marks a task as done based on user input.
     * If the command contains an empty description, an error message is printed.
     *
     * @param command The user input command containing the index of the task to be marked.
     */
    public static void mark(String command) {
        try {
            int indexToMark = Parser.getNumberToMark(command);
            taskList.get(indexToMark).markAsDone();
            Printer.printMarkResult(taskList.get(indexToMark));
        } catch (IllegalCommandException e) {
            Printer.printMarkExceptionMessage(ILLEGAL_COMMAND_INDEX);
        } catch (IndexOutOfBoundsException e) {
            Printer.printMarkExceptionMessage(OUT_OF_BOUNDS_INDEX);
        } catch (Error e) {
            Printer.printMarkExceptionMessage(ERROR_INDEX);
        } catch (RuntimeException e) {
            Printer.printMarkExceptionMessage(RUNTIME_EXCEPTION_INDEX);
        }
    }

    /**
     * Unmarks a task as based on user input.
     * If the command contains an empty description, an error message is printed.
     *
     * @param command The user input command containing the index of the task to be unmarked.
     */
    public static void unmark(String command) {
        try {
            int indexToUnmark = Parser.getNumberToUnmark(command);
            taskList.get(indexToUnmark).unmarkAsDone();
            Printer.printUnmarkResult(taskList.get(indexToUnmark));
        } catch (IllegalCommandException e) {
            Printer.printUnmarkExceptionMessage(ILLEGAL_COMMAND_INDEX);
        } catch (IndexOutOfBoundsException e) {
            Printer.printUnmarkExceptionMessage(OUT_OF_BOUNDS_INDEX);
        } catch (Error e) {
            Printer.printUnmarkExceptionMessage(ERROR_INDEX);
        } catch (RuntimeException e) {
            Printer.printUnmarkExceptionMessage(RUNTIME_EXCEPTION_INDEX);
        }
    }

    /**
     * Deletes a task from the list based on user input.
     * If the command contains an empty description, an error message is printed.
     *
     * @param command The user input command containing the index of the task to be deleted.
     */
    public static void delete(String command) {
        try {
            int indexToDelete = Parser.getNumberToDelete(command);
            Task task = taskList.get(indexToDelete);
            taskList.remove(indexToDelete);
            Printer.printDeleteResult(taskList, task);
        } catch (IllegalCommandException e) {
            Printer.printDeleteExceptionMessage(ILLEGAL_COMMAND_INDEX);
        } catch (IndexOutOfBoundsException e) {
            Printer.printDeleteExceptionMessage(OUT_OF_BOUNDS_INDEX);
        } catch (RuntimeException e) {
            Printer.printDeleteExceptionMessage(RUNTIME_EXCEPTION_INDEX);
        }
    }

    /**
     * Searches for tasks in the task list that contain the specified keyword.
     * If the command contains an empty description, an error message is printed.
     *
     * @param command The user input containing the keyword to search for.
     */
    public static void find(String command) {
        try {
            if (Parser.getKeyword(command).trim().isEmpty()) {
                Printer.printEmptyCommandMessage();
                return;
            }
            Printer.printLine();
            String keyword = Parser.getKeyword(command);
            Printer.printFindResult();
            for (Task tasks : taskList) {
                String taskDescription = tasks.getDescription();
                if (taskDescription.contains(keyword)) {
                    Printer.printEntry(tasks);
                }
            }
            Printer.printLine();
        } catch (IndexOutOfBoundsException e) {
            Printer.printFindExceptionMessage();
        }
    }

    /**
     * Generates and returns a random fun fact about Gojo Satoru.
     *
     * @return A randomly selected fun fact about Gojo.
     */
    private static String getRandomGojoFact() {
        Random random = new Random();
        int index = random.nextInt(FUN_FACTS.length);
        return FUN_FACTS[index];
    }

    /**
     * Prints a random fun fact about Gojo Satoru.
     */
    public static void funFact() {
        Printer.printFunFact(getRandomGojoFact());
    }

    /**
     * Prints the help menu for the chatbot.
     */
    public static void help() {
        Printer.printHelp();
    }

    /**
     * Adds a task to the task list.
     *
     * @param task The task to be added.
     */
    public static void addTask(Task task) {
        taskList.add(task);
    }

}
