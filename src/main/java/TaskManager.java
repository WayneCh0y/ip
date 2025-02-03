import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static List<Task> taskList;

    private static boolean isValidTodoCommand(String command) {
        String[] words = command.split(" ", 2);
        return words.length > 1;
    }

    private static boolean isValidDeadlineCommand(String command) {
        String[] words = command.split(" ", 2);
        if (words.length < 2) {
            return false;
        }
        String[] deadlineCommand = words[1].split("\\s*/by\\s*");
        return deadlineCommand.length > 1;
    }

    private static boolean isValidEventCommand(String command) {
        String[] words = command.split(" ", 2);
        if (words.length < 2) {
            return false;
        }
        String[] eventCommand = words[1].split("\\s*/from\\s*|\\s*/to\\s*");
        return eventCommand.length > 2;
    }

    private static boolean isValidMarkCommand(String command) {
        String[] words = command.split(" ", 2);
        if (words.length < 2) {
            return false;
        }
        int numberToMark = Integer.parseInt(words[1]);
        int indexToMark = numberToMark - 1;
        return numberToMark <= taskList.size() && numberToMark > 0 && !taskList.get(indexToMark).getStatus();
    }

    private static boolean isValidUnmarkCommand(String command) {
        String[] words = command.split(" ", 2);
        if (words.length < 2) {
            return false;
        }
        int numberToMark = Integer.parseInt(words[1]);
        int indexToMark = numberToMark - 1;
        return numberToMark <= taskList.size() && numberToMark > 0 && taskList.get(indexToMark).getStatus();
    }

    public TaskManager() {
        taskList = new ArrayList<>();
    }

    public static List<Task> getList() {
        return taskList;
    }

    public static Task getTaskAtIndex(int index) {
        return taskList.get(index);
    }

    public static int getListSize() {
        return taskList.size();
    }

    public static void printTaskList() {
        int index = 0;
        Printer.printLine();
        System.out.println("Alright, here's the lineup of tasks on your list! Let's breeze through them.");

        for (Task task : taskList) {
            Printer.printIndexNumber(index);
            Printer.printEntry(task);
            index++;
        }

        Printer.printLine();
    }

    public static void todo(String line) {
        if (!isValidTodoCommand(line)) {
            return;
        }
        String[] split = line.split(" ", 2);
        String taskDescription = split[1];
        Task todoTask = new Todo(taskDescription);
        taskList.add(todoTask);
        Printer.printTaskAdded(getListSize(), todoTask);
    }

    public static void deadline(String line) {
        if (!isValidDeadlineCommand(line)) {
            return;
        }
        String[] split = line.split(" ", 2);
        String[] deadlineSpecifics = split[1].split("\\s*/by\\s*");
        Task deadlineTask = new Deadline(deadlineSpecifics[0], deadlineSpecifics[1]);
        taskList.add(deadlineTask);
        Printer.printTaskAdded(getListSize(), deadlineTask);
    }

    public static void event(String line) {
        if (!isValidEventCommand(line)) {
            return;
        }
        String[] split = line.split(" ", 2);
        String[] eventSpecifics = split[1].split("\\s*/from\\s*|\\s*/to\\s*");
        Task eventTask = new Event(eventSpecifics[0], eventSpecifics[1], eventSpecifics[2]);
        taskList.add(eventTask);
        Printer.printTaskAdded(getListSize(), eventTask);
    }

    public static void mark(String line) {
        if (!isValidMarkCommand(line)) {
            return;
        }
        String[] split = line.split(" ", 2);
        int numberToMark = Integer.parseInt(split[1]);
        int indexToMark = numberToMark - 1;
        taskList.get(indexToMark).markAsDone();
        Printer.printMarkResult(taskList.get(indexToMark));
    }

    public static void unmark(String line) {
        if (!isValidUnmarkCommand(line)) {
            return;
        }
        String[] split = line.split(" ", 2);
        int numberToUnmark = Integer.parseInt(split[1]);
        int indexToUnmark = numberToUnmark - 1;
        taskList.get(indexToUnmark).unmarkAsDone();
        Printer.printUnmarkResult(taskList.get(indexToUnmark));
    }
}
