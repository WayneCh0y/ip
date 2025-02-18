import Managers.Printer;
import Managers.TaskManager;

import java.util.Scanner;
import java.io.IOException;

public class Gojo {

    private static String getTaskType(String line) {
        return (line.split(" ", 2))[0];
    }

    private static void start(Scanner in, TaskManager taskManager) {
        String line;
        while(true) {
            line = in.nextLine();
            String taskType = getTaskType(line);
            switch (taskType) {
            case "bye":
                return;
            case "list":
                taskManager.printTaskList();
                break;
            case "todo":
                taskManager.todo(line);
                break;
            case "deadline":
                taskManager.deadline(line);
                break;
            case "event":
                taskManager.event(line);
                break;
            case "mark":
                taskManager.mark(line);
                break;
            case "unmark":
                taskManager.unmark(line);
                break;
            case "delete":
                taskManager.delete(line);
                break;
            default:
                System.out.println("OOPS~! You've officially confused even me! Try again, maybe with actual commands?");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TaskManager taskManager = FileManager.load();
        Scanner in = new Scanner(System.in);
        Printer.chatbotGreeting();
        start(in, taskManager);
        Printer.end();
        FileManager.save(TaskManager.getTaskList());
    }
}
