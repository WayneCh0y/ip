package Managers;

import Managers.Exceptions.IllegalCommandException;
import TaskItems.Deadline;
import TaskItems.Event;
import TaskItems.Task;
import TaskItems.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of tasks, providing functionalities to add, remove, and modify tasks.
 */
public class TaskManager {
    private static List<Task> taskList;

    private static final int TASK_DESCRIPTION_INDEX = 0;
    private static final int DEADLINE_BY_INDEX = 1;
    private static final int EVENT_FROM_INDEX = 1;
    private static final int EVENT_TO_INDEX = 2;

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
     *
     * @param command The user input command.
     */
    public static void todo(String command) {
        try {
            Task task = new Todo(Parser.getTodo(command));
            taskList.add(task);
            Printer.printTaskAdded(getListSize(), task);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops~! Looks like you forgot something important. A Todo without a description?");
        }
    }

    /**
     * Adds a new Deadline task to the list.
     *
     * @param command The user input command containing the task description and deadline.
     */
    public static void deadline(String command) {
        try {
            String[] deadlineSpecifics = Parser.getDeadline(command);
            Task deadlineTask = new Deadline(deadlineSpecifics[TASK_DESCRIPTION_INDEX], deadlineSpecifics[DEADLINE_BY_INDEX]);
            taskList.add(deadlineTask);
            Printer.printTaskAdded(getListSize(), deadlineTask);
        } catch (IllegalCommandException e) {
            System.out.println("A deadline without a description? Is this a secret mission?");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Hey hey~! Don't forget to set the deadline okay?");
        } catch (IllegalArgumentException e) {
            System.out.println("You're almost there! Just tweak that date to yyyy-MM-dd.");
        }
    }

    /**
     * Adds a new Event task to the list.
     *
     * @param command The user input command containing the task description and event timeline.
     */
    public static void event(String command) {
        try {
            String[] eventSpecifics = Parser.getEvent(command);
            Task eventTask = new Event(eventSpecifics[TASK_DESCRIPTION_INDEX], eventSpecifics[EVENT_FROM_INDEX], eventSpecifics[EVENT_TO_INDEX]);
            taskList.add(eventTask);
            Printer.printTaskAdded(getListSize(), eventTask);
        } catch(IllegalCommandException e) {
            System.out.println("What is this? An event with no details?");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Is this event happening today, tomorrow, or in the next century?");
        }
    }

    /**
     * Marks a task as done based on user input.
     *
     * @param command The user input command containing the index of the task to be marked.
     */
    public static void mark(String command) {
        try {
            int indexToMark = Parser.getNumberToMark(command);
            taskList.get(indexToMark).markAsDone();
            Printer.printMarkResult(taskList.get(indexToMark));
        } catch (IllegalCommandException e) {
            System.out.println("Uh-oh~! You want me to mark something as done, but... what exactly?");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Huh? That task is not even on the list! Are you seeing things?");
        } catch (Error e) {
            System.out.println("Eh? That task is already done! Trying to get extra credit?");
        } catch (RuntimeException e) {
            System.out.println("Uh... am i supposed to use limitless to figure this out?");
        }
    }

    /**
     * Unmarks a task as based on user input.
     *
     * @param command The user input command containing the index of the task to be unmarked.
     */
    public static void unmark(String command) {
        try {
            int indexToUnmark = Parser.getNumberToUnmark(command);
            taskList.get(indexToUnmark).unmarkAsDone();
            Printer.printUnmarkResult(taskList.get(indexToUnmark));
        } catch (IllegalCommandException e) {
            System.out.println("Woah there~! What am I supposed to unmark here?");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Huh? That task is not even on the list! Are you seeing things?");
        } catch (Error e) {
            System.out.println("Eh? That task isn't even done! Trying to reverse nothing now?");
        } catch (RuntimeException e) {
            System.out.println("Huh? You want me to unmark... whatever that is?");
        }
    }

    /**
     * Deletes a task from the list based on user input.
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
            System.out.println("Are you trying to delete... nothing? Do you even know what you’re doing?");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Huh? Trying to erase something that’s not even there? That’s cute.");
        } catch (RuntimeException e) {
            System.out.println("Okay, what’s this? Are we speaking in code now?");
        }
    }

    /**
     * Searches for tasks in the task list that contain the specified keyword.
     *
     * @param command The user input containing the keyword to search for.
     */
    public static void find(String command) {
        try {
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
            System.out.println("My bad, I totally spaced out. What was that again?");
        }
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
