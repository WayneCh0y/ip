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
    public static final String FILEPATH = "data/Gojo.txt";

    protected FileManager fileManager;
    protected TaskManager taskManager;

    /**
     * Constructs the Gojo chatbot instance.
     * Initializes the file manager, printer, and loads existing saved data.
     *
     * @param filepath The path to the file where tasks are stored.
     */
    public Gojo(String filepath) {
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
     */
    private void start() {
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

    public static void main(String[] args) {
        new Gojo(FILEPATH).start();
    }
}
