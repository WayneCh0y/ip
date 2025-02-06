import java.util.Scanner;

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
            default:
                System.out.println("Eh? Sorry, but that’s a little above my head. Mind explaining again?");
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
