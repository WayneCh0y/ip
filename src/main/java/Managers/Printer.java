package Managers;

import TaskItems.Task;

import java.util.List;

/**
 * Handles printing messages to the console for user interaction.
 * Provides various methods to display task-related updates and chatbot responses.
 */

public class Printer {
    private static final String LINE_SEPARATOR = "____________________________________________________________";
    private static final String GOJO_ICON = "               :.        .:                      \n" +
            "               :-.     .:: .                      \n" +
            "              -.::    .-  . .-.    -              \n" +
            "             :...-   .+  :.+      :               \n" +
            "             :   +  .- .:-.     :.                \n" +
            "             - . %  .. .=      -                  \n" +
            "            .    -. -  :      .-:-=-:-.   :.      \n" +
            "        =   :     - .                .   -..      \n" +
            "        +:  .     ::                  . +.+       \n" +
            "        -+-  .     .                  :  .        \n" +
            "         *.=                           .+         \n" +
            "         .= =.     .:                 .-          \n" +
            "       .....       :.                  .+         \n" +
            "     =.    -=      -                    .-        \n" +
            "   -..--           =     .               :-       \n" +
            " .      ::         =       .              :-      \n" +
            "          :      . =    .                  ::::::.\n" +
            "        .-:      : =    .     .              ...= \n" +
            "      .=        . :.     ..                   :-  \n" +
            "     -.         ..::.    .  .     ..  .    .-:    \n" +
            "    =  --::       :+******=*+:   :   ::.     .-   \n" +
            "   .... :.. --=*##*++******#*###*--=.      ::-:+. \n" +
            "   :.   =::****+=-=-=########******--*.    ..  .. \n" +
            "   .   :: *++****###**######**+*****+==+.   +     \n" +
            "       -. .++#############*++++##*++=-.:+     \n" +
            "       -  :+######+=+*#######***######+--*  .     \n" +
            "       .  .+++*#+====+######+-===*#####*+-  :     \n" +
            "          .+=###*+*+*####=-*****#*=*#=*.  :     \n" +
            "          :+*#####*==+*###*=*#######+=--*. .      \n" +
            "          :+=++*####*-+###**#+===#####+*+         \n" +
            "        :#++###+=###=#####*-+--*###-----=         \n" +
            "       := .*=+*##**###-++==+-+*##+*###=-*:        \n" +
            "       #.=:+..::*####:     .-=*###%#-:.:..+       \n" +
            "       #..=#:.... :.          :. ....:... ::      \n" +
            "       .-.-+:....                ....-:*-. +      \n" +
            "        -. .=....     #          ...- =:+  =      \n" +
            "        .::.-=.        :-=:           ....+       \n" +
            "          ...:+:                   .+   .-        \n" +
            "               ++..             ..-+ +++.         \n" +
            "              :=++*+=-:    .:-=++*:               \n" +
            "               *+#####%+=--++##=*               \n" +
            "               ==*####%+########*+:               \n" +
            "               +==#####+######*+=*.";

    private static final int ILLEGAL_COMMAND_MESSAGE_INDEX = 0;
    private static final int OUT_OF_BOUNDS_MESSAGE_INDEX = 1;
    private static final int ILLEGAL_ARGUMENT_MESSAGE_INDEX = 2;
    private static final int ERROR_MESSAGE_INDEX = 3;
    private static final int RUNTIME_EXCEPTION_MESSAGE_INDEX = 4;

    /**
     * Prints the chatbot's greeting message.
     */
    public static void chatbotGreeting() {
        printLine();
        printGojo();
        System.out.println("Hey there! The name's Gojo. The strongest sorcerer you'll ever meet.");
        System.out.println("What can I do for you?");
        printHelp();
    }

    /**
     * Prints the chatbot's possible commands.
     */
    public static void printHelp() {
        printLine();
        System.out.println("\nAvailable Commands:");
        System.out.println("1. list (Shows the current list of items)");
        System.out.println("2. todo <task description> (Adds a todo task)");
        System.out.println("3. deadline <task description> /by <YYYY-MM-DD> (Adds a deadline task)");
        System.out.println("4. event <task description> /from <start> /to <end> (Adds an event task)");
        System.out.println("5. mark <list index> (Marks a task)");
        System.out.println("6. unmark <list index> (Unmarks a task)");
        System.out.println("7. delete <list index> (Deletes a task)");
        System.out.println("8. find <keyword> (Finds a task with the specified keyword)");
        System.out.println("9. bye (Exits Gojo chatbot)");
        System.out.println("10. gojo (Try me)");
        System.out.println("11. help (Lists out all possible commands)");
        printLine();
    }

    /**
     * Prints the chatbot's character icon.
     */
    private static void printGojo() {
        System.out.println(GOJO_ICON);
    }

    /**
     * Prints the chatbot's exit message.
     */
    public static void end() {
        System.out.println("Bye! Don't miss me too much, okay?");
        printLine();
    }

    /**
     * Prints a line separator.
     */
    public static void printLine() {
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Prints the index number for a task, as shown in the list.
     *
     * @param index The index of the task.
     */
    public static void printIndexNumber(int index) {
        System.out.print(getIndexNumber(index) + ". ");
    }

    /**
     * Converts a zero-based index to a one-based index for display.
     *
     * @param index The zero-based index.
     * @return The one-based index.
     */
    private static int getIndexNumber(int index) {
        return index + 1;
    }

    /**
     * Prints a task entry.
     *
     * @param task The task to be printed.
     */
    public static void printEntry(Task task) {
        System.out.println(task);
    }

    /**
     * Prints a message indicating that a task has been marked.
     *
     * @param task The task that has to be marked.
     */
    public static void printMarkResult(Task task) {
        printLine();
        System.out.println("Awesome! Task marked as completed:");
        printEntry(task);
        printLine();
    }

    /**
     * Prints a message indicating that a task has been unmarked.
     *
     * @param task The task that has to be unmarked.
     */
    public static void printUnmarkResult(Task task) {
        printLine();
        System.out.println("Okay, I've marked this as not done yet." +
                " Guess even perfection takes a little time huh?:");
        printEntry(task);
        printLine();
    }

    /**
     * Prints a message stating that a task has been added.
     *
     * @param listSize The updated number of tasks in the list.
     * @param task The task that was added.
     */
    public static void printTaskAdded(int listSize, Task task) {
        Printer.printLine();
        System.out.println("Got it! Task added.");
        System.out.println(task);
        printListSize(listSize);
        Printer.printLine();
    }

    /**
     * Prints the current number of tasks in the list.
     *
     * @param listSize The number of tasks in the list.
     */
    private static void printListSize(int listSize) {
        System.out.println("Now you have " + listSize + " tasks in the list.");
    }

    /**
     * Prints all tasks in the task list.
     * If the list is empty, a message is displayed.
     * Otherwise, the method prints a formatted list of tasks with their respective indices.
     *
     * @param taskList The list of tasks.
     */
    public static void printTaskList(List<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("I'd use my Six Eyes to find something… but yeah, still nothing.");
            return;
        }

        int index = 0;
        Printer.printLine();
        System.out.println("Alright, here's the lineup of tasks on your list!" +
                " Let's breeze through them.");

        for (Task task : taskList) {
            Printer.printIndexNumber(index);
            Printer.printEntry(task);
            index++;
        }

        Printer.printLine();
    }

    /**
     * Prints a message stating the deletion of a task.
     *
     * @param taskList The updated list of tasks.
     * @param task The task that was deleted.
     */
    public static void printDeleteResult(List<Task> taskList, Task task) {
        Printer.printLine();
        System.out.println("Ah, I see what you did there!" +
                " Was that a sneaky Gojo-style move to make the task disappear?");
        printEntry(task);
        printListSize(taskList.size());
        Printer.printLine();
    }

    /**
     * Prints a message indicating that matching tasks have been found.
     */
    public static void printFindResult() {
        System.out.println("Boom! Found your matching tasks.");
    }

    /**
     * Prints an error message when a file loading issue occurs.
     */
    public static void printLoadingError() {
        System.out.println("Hah, even I can't load this file? Must be cursed!");
    }

    /**
     * Prints a message for unknown or invalid user commands.
     */
    public static void printUnknownCommandMessage() {
        System.out.println("OOPS~! You've officially confused even me!" +
                " Try again, maybe with actual commands?");
    }

    /**
     * Prints an exception message when a Todo task is created without a description.
     */
    public static void printTodoExceptionMessage() {
        System.out.println("Oops~! Looks like you forgot something important." +
                " A Todo without a description?");
    }

    /**
     * Prints an exception message based on the provided message index when handling a Deadline task.
     *
     * @param messageIndex The index indicating the type of error
     */
    public static void printDeadlineExceptionMessage(int messageIndex) {
        switch (messageIndex) {
        case ILLEGAL_COMMAND_MESSAGE_INDEX:
            System.out.println("Whoa there, are you trying to curse my system with that command?");
            return;
        case OUT_OF_BOUNDS_MESSAGE_INDEX:
            System.out.println("Hey hey~! Don't forget to set the deadline okay?");
            return;
        case ILLEGAL_ARGUMENT_MESSAGE_INDEX:
            System.out.println("You're almost there! Just tweak that date to yyyy-MM-dd.");
        }
    }

    /**
     * Prints an exception message based on the provided message index when handling an Event task.
     *
     * @param messageIndex The index indicating the type of error
     */
    public static void printEventExceptionMessage(int messageIndex) {
        switch (messageIndex) {
        case ILLEGAL_COMMAND_MESSAGE_INDEX:
            System.out.println("Whoa there, are you trying to curse my system with that command?");
            return;
        case OUT_OF_BOUNDS_MESSAGE_INDEX:
            System.out.println("Is this event happening today, tomorrow, or in the next century?");
        }
    }

    /**
     * Prints an exception message based on the provided message index when marking a task as done.
     *
     * @param messageIndex The index indicating the type of error
     */
    public static void printMarkExceptionMessage(int messageIndex) {
        switch (messageIndex) {
        case ILLEGAL_COMMAND_MESSAGE_INDEX:
            System.out.println("Uh-oh~! You want me to mark something as done, but... what exactly?");
            return;
        case OUT_OF_BOUNDS_MESSAGE_INDEX:
            System.out.println("Huh? That task is not even on the list! Are you seeing things?");
            return;
        case ERROR_MESSAGE_INDEX:
            System.out.println("Eh? That task is already done! Trying to get extra credit?");
            return;
        case RUNTIME_EXCEPTION_MESSAGE_INDEX:
            System.out.println("Uh... am i supposed to use limitless to figure this out?");
        }
    }

    /**
     * Prints an exception message based on the provided message index when unmarking a task.
     *
     * @param messageIndex The index indicating the type of error
     */
    public static void printUnmarkExceptionMessage(int messageIndex) {
        switch (messageIndex) {
        case ILLEGAL_COMMAND_MESSAGE_INDEX:
            System.out.println("Woah there~! What am I supposed to unmark here?");
            return;
        case OUT_OF_BOUNDS_MESSAGE_INDEX:
            System.out.println("Huh? That task is not even on the list! Are you seeing things?");
            return;
        case ERROR_MESSAGE_INDEX:
            System.out.println("Eh? That task isn't even done! Trying to reverse nothing now?");
            return;
        case RUNTIME_EXCEPTION_MESSAGE_INDEX:
            System.out.println("Huh? You want me to unmark... whatever that is?");
        }
    }

    /**
     * Prints an exception message based on the provided message index when deleting a task.
     *
     * @param messageIndex The index indicating the type of error
     */
    public static void printDeleteExceptionMessage(int messageIndex) {
        switch (messageIndex) {
        case ILLEGAL_COMMAND_MESSAGE_INDEX:
            System.out.println("Are you trying to delete... nothing?" +
                    " Do you even know what you're doing?");
            return;
        case OUT_OF_BOUNDS_MESSAGE_INDEX:
            System.out.println("Huh? Trying to erase something that's not even there? That's cute.");
            return;
        case RUNTIME_EXCEPTION_MESSAGE_INDEX:
            System.out.println("Okay, what's this? Are we speaking in code now?");
        }
    }

    /**
     * Prints an exception message when no search keyword is provided for finding a task.
     */
    public static void printFindExceptionMessage() {
        System.out.println("My bad, I totally spaced out. What was that again?");
    }

    /**
     * Prints a message when the command inputted by the user is empty.
     */
    public static void printEmptyCommandMessage() {
        System.out.println("Empty command, huh? You're trying to tell me something without saying anything?");
    }

    /**
     * Prints the given fun fact to the console.
     *
     * @param fact The fun fact to be printed.
     */
    public static void printFunFact(String fact) {
        System.out.println(fact);
    }
}
