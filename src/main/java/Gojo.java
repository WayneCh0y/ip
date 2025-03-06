import Commands.Command;
import Commands.ExitCommand;
import Managers.FileManager;
import Managers.Parser;
import Managers.Printer;
import Managers.TaskManager;

import java.util.Scanner;
import java.io.IOException;

public class Gojo {
    private FileManager fileManager;
    private TaskManager taskManager;
    private Printer printer;

    public Gojo(String filepath) {
        printer = new Printer();
        fileManager = new FileManager(filepath);
        try {
            taskManager = FileManager.load();
        } catch (IOException e) {
            Printer.printLoadingError();
            taskManager = new TaskManager();
        }
    }

    private static void start() throws IOException {
        Scanner in = new Scanner(System.in);
        Printer.chatbotGreeting();

        while (true) {
            String commandString = in.nextLine();
            Command command = Parser.parseCommand(commandString);

            try {
                command.execute();
                if (command instanceof ExitCommand) {
                    break;
                }
            } catch (IOException e) {
                Printer.printLoadingError();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Gojo("data/Gojo.txt").start();
    }
}
