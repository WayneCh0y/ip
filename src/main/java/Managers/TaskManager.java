package Managers;

import Managers.Exceptions.IllegalCommandException;
import TaskItems.Deadline;
import TaskItems.Event;
import TaskItems.Task;
import TaskItems.Todo;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static List<Task> taskList;
    private static int MIN_WORD_LEN = 2;


    private static void isValidDeadlineCommand(String command) throws IllegalCommandException {
        String[] words = command.split(" ", MIN_WORD_LEN);
        if (words.length < MIN_WORD_LEN) {
            throw new IllegalCommandException();
        }
        if (words[1].split("\\s*/by\\s*").length < MIN_WORD_LEN) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static void isValidEventCommand(String command) throws IllegalCommandException {
        String[] words = command.split(" ", MIN_WORD_LEN);
        if (words.length < MIN_WORD_LEN) {
            throw new IllegalCommandException();
        }
        if (words[1].split("\\s*/from\\s*|\\s*/to\\s*").length < 3) {
            throw new Error();
        }
    }

    private static void isValidMarkCommand(String command) throws IllegalCommandException {
        String[] words = command.split(" ", MIN_WORD_LEN);
        if (words.length < MIN_WORD_LEN) {
            throw new IllegalCommandException();
        }

        int numberToMark;

        try {
            numberToMark = Integer.parseInt(words[1]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        int indexToMark = numberToMark - 1;

        if (numberToMark > taskList.size() || numberToMark <= 0) {
            throw new IndexOutOfBoundsException();
        }

        if (taskList.get(indexToMark).getStatus()) {
            throw new Error();
        }
    }

    private static void isValidUnmarkCommand(String command) throws IllegalCommandException {
        String[] words = command.split(" ", MIN_WORD_LEN);
        if (words.length < MIN_WORD_LEN) {
            throw new IllegalCommandException();
        }

        int numberToMark;

        try {
            numberToMark = Integer.parseInt(words[1]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        int indexToMark = numberToMark - 1;
        if (numberToMark > taskList.size() || numberToMark <= 0) {
            throw new IndexOutOfBoundsException();
        }

        if (!taskList.get(indexToMark).getStatus()) {
            throw new Error();
        }
    }

    public static void isValidDeleteCommand(String command) throws IllegalCommandException {
        String[] words = command.split(" ", MIN_WORD_LEN);
        if (words.length < MIN_WORD_LEN) {
            throw new IllegalCommandException();
        }

        int numberToDelete;

        try {
            numberToDelete = Integer.parseInt(words[1]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        if (numberToDelete > taskList.size() || numberToDelete <= 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public TaskManager() {
        taskList = new ArrayList<>();
    }

    public static int getListSize() {
        return taskList.size();
    }

    public static List<Task> getTaskList() {
        return taskList;
    }

    public static void printTaskList() {
        Printer.printTaskList(taskList);
    }

    public static void todo(String line) {
        try {
            String[] split = line.split(" ", MIN_WORD_LEN);
            String taskDescription = split[1];
            Task todoTask = new Todo(taskDescription);
            taskList.add(todoTask);
            Printer.printTaskAdded(getListSize(), todoTask);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops~! Looks like you forgot something important. A Todo without a description?");
        }
    }

    public static void deadline(String line) {
        try {
            isValidDeadlineCommand(line);
        } catch (IllegalCommandException e) {
            System.out.println("A deadline without a description? Is this a secret mission?");
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Hey hey~! Don't forget to set the deadline okay?");
            return;
        }

        String[] split = line.split(" ", MIN_WORD_LEN);
        String[] deadlineSpecifics = split[1].split("\\s*/by\\s*");
        Task deadlineTask = new Deadline(deadlineSpecifics[0], deadlineSpecifics[1]);
        taskList.add(deadlineTask);
        Printer.printTaskAdded(getListSize(), deadlineTask);
    }

    public static void event(String line) {
        try {
            isValidEventCommand(line);
        } catch(IllegalCommandException e) {
            System.out.println("What is this? An event with no details?");
            return;
        } catch (Error e) {
            System.out.println("Is this event happening today, tomorrow, or in the next century?");
            return;
        }

        String[] split = line.split(" ", MIN_WORD_LEN);
        String[] eventSpecifics = split[1].split("\\s*/from\\s*|\\s*/to\\s*");
        Task eventTask = new Event(eventSpecifics[0], eventSpecifics[1], eventSpecifics[2]);
        taskList.add(eventTask);
        Printer.printTaskAdded(getListSize(), eventTask);
    }

    public static void mark(String line) {
        try {
            isValidMarkCommand(line);
        } catch (IllegalCommandException e) {
            System.out.println("Uh-oh~! You want me to mark something as done, but... what exactly?");
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Huh? That task is not even on the list! Are you seeing things?");
            return;
        } catch (Error e) {
            System.out.println("Eh? That task is already done! Trying to get extra credit?");
            return;
        } catch (RuntimeException e) {
            System.out.println("Uh... am i supposed to use limitless to figure this out?");
            return;
        }
        String[] split = line.split(" ", MIN_WORD_LEN);
        int numberToMark = Integer.parseInt(split[1]);
        int indexToMark = numberToMark - 1;
        taskList.get(indexToMark).markAsDone();
        Printer.printMarkResult(taskList.get(indexToMark));
    }

    public static void unmark(String line) {
        try {
            isValidUnmarkCommand(line);
        } catch (IllegalCommandException e) {
            System.out.println("Woah there~! What am I supposed to unmark here?");
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Huh? That task is not even on the list! Are you seeing things?");
            return;
        } catch (Error e) {
            System.out.println("Eh? That task isn't even done! Trying to reverse nothing now?");
            return;
        } catch (RuntimeException e) {
            System.out.println("Huh? You want me to unmark... whatever that is?");
            return;
        }
        String[] split = line.split(" ", MIN_WORD_LEN);
        int numberToUnmark = Integer.parseInt(split[1]);
        int indexToUnmark = numberToUnmark - 1;
        taskList.get(indexToUnmark).unmarkAsDone();
        Printer.printUnmarkResult(taskList.get(indexToUnmark));
    }

    public static void delete(String line) {
        try {
            isValidDeleteCommand(line);
        } catch (IllegalCommandException e) {
            System.out.println("Are you trying to delete... nothing? Do you even know what you’re doing?");
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Huh? Trying to erase something that’s not even there? That’s cute.");
            return;
        } catch (RuntimeException e) {
            System.out.println("Okay, what’s this? Are we speaking in code now?");
            return;
        }
        String[] split = line.split(" ", MIN_WORD_LEN);
        int numberToDelete = Integer.parseInt(split[1]);
        int indexToDelete = numberToDelete - 1;
        Task task = taskList.get(indexToDelete);
        taskList.remove(indexToDelete);
        Printer.printDeleteResult(taskList, task);
    }

    public static void addTask(Task task) {
        taskList.add(task);
    }
}
