import Commands.Command;
import Commands.ExitCommand;
import Managers.FileManager;
import Managers.Parser;
import Managers.Printer;
import Managers.TaskManager;

import java.util.Scanner;
import java.io.IOException;

/**
 * The main chatbot class that handles user interactions,
 */
public class Gojo {
    private FileManager fileManager;
    private TaskManager taskManager;
    private Printer printer;

    /**
     * Constructs the Gojo chatbot instance.
     * Initializes the file manager, printer, and loads existing saved data.
     *
     * @param filepath The path to the file where tasks are stored.
     */
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


    /**
     * Starts the chatbot, continuously taking user input and executing commands.
     * Terminates when the user inputs an exit command.
     *
     * @throws IOException If an error occurs during file operations.
     */
    private static void start() {
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
