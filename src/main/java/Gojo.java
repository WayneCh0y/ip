import java.util.Scanner;
import java.util.*;

public class Gojo {

    public static void markAsDone(List<Task> list, int numToMark) {
        if (isNotValidToMark(list, numToMark)) {
            return;
        }
        list.get(numToMark - 1).markAsDone();
        Printer.printMarkResult(list, numToMark - 1);
    }

    private static boolean isNotValidToMark(List<Task> list, int num) {
        return num > list.size() || num < 0 || list.get(num - 1).getStatus();
    }


    public static void unmarkAsDone(List<Task> list, int numToUnmark) {
        if (isNotValidToUnmark(list, numToUnmark)) {
            return;
        }
        list.get(numToUnmark - 1).unmarkAsDone();
        Printer.printUnmarkResult(list, numToUnmark - 1);
    }

    private static boolean isNotValidToUnmark(List<Task> list, int num) {
        return num > list.size() || num < 0 || !list.get(num - 1).getStatus();
    }

    public static void main(String[] args) {
        List<Task> listItems = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Printer.chatbotGreeting();
        start(in, listItems);
        Printer.end();
    }

    private static void start(Scanner in, List<Task> listItems) {
        String line;

        while(true) {
            line = in.nextLine();
            String[] words = line.split(" ", 2);
            String taskType = words[0];

            switch (taskType) {
            case "bye":
                return;
            case "list":
                Printer.printList(listItems);
                continue;
            case "todo":
                String taskDescription = words[1];
                Task todoTask = new Todo(taskDescription);
                Printer.printTaskAdded(listItems, todoTask);
                continue;
            case "deadline":
                String[] deadlineTaskSpecifics = words[1].split("\\s*/by\\s*");
                Task deadlineTask = new Deadline(deadlineTaskSpecifics[0], deadlineTaskSpecifics[1]);
                Printer.printTaskAdded(listItems, deadlineTask);
                continue;
            case "event":
                String[] eventTaskSpecifics = words[1].split("\\s*/from\\s*|\\s*/to\\s*");
                Task eventTask = new Event(eventTaskSpecifics[0], eventTaskSpecifics[1], eventTaskSpecifics[2]);
                Printer.printTaskAdded(listItems, eventTask);
                continue;
            case "mark":
                int numToMark = Integer.parseInt(words[1]);
                markAsDone(listItems, numToMark);
                continue;
            case "unmark":
                int numToUnmark = Integer.parseInt(words[1]);
                unmarkAsDone(listItems, numToUnmark);
                continue;
            }

            Task task = new Task(line);
            Printer.printTaskAdded(listItems, task);
        }
    }

}
