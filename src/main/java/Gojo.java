import java.util.Scanner;

public class Gojo {

    private static String getTaskType(String line, Scanner in) {
        return (line.split(" ", 2))[0];
    }

    private static void start(Scanner in, TaskManager taskManager) {
        String line;
        while(true) {
            line = in.nextLine();
            String taskType = getTaskType(line, in);
            switch (taskType) {
            case "bye":
                return;
            case "list":
                taskManager.printTaskList();
                continue;
            case "todo":
                taskManager.todo(line);
                continue;
            case "deadline":
                taskManager.deadline(line);
                continue;
            case "event":
                taskManager.event(line);
                continue;
            case "mark":
                taskManager.mark(line);
                continue;
            case "unmark":
                taskManager.unmark(line);
            }
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner in = new Scanner(System.in);
        Printer.chatbotGreeting();
        start(in, taskManager);
        Printer.end();
    }
}
