package Managers;

import TaskItems.Task;

import java.util.List;

/**
 * Handles printing messages to the console for user interaction.
 * Provides various methods to display task-related updates and chatbot responses.
 */

public class Printer {
    private static final String LINE_SEPARATOR = "____________________________________________________________";

    /**
     * Prints the chatbot's greeting message.
     */
    public static void chatbotGreeting() {
        printLine();
        System.out.println("Hey there! The name's Gojo. The strongest sorcerer you'll ever meet.");
        System.out.println("What can I do for you?");
        printLine();
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
        System.out.println("Okay, I've marked this as not done yet. Guess even perfection takes a little time huh?:");
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
     *
     * @param taskList The list of tasks.
     */
    public static void printTaskList(List<Task> taskList) {
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

    /**
     * Prints a message stating the deletion of a task.
     *
     * @param taskList The updated list of tasks.
     * @param task The task that was deleted.
     */
    public static void printDeleteResult(List<Task> taskList, Task task) {
        Printer.printLine();
        System.out.println("Ah, I see what you did there! Was that a sneaky Gojo-style move to make the task disappear?");
        printEntry(task);
        printListSize(taskList.size());
        Printer.printLine();
    }

<<<<<<< HEAD
    /**
     * Prints an error message when a file loading issue occurs.
     */
=======
    public static void printFindResult() {
        System.out.println("Boom! Found your matching tasks.");
    }

>>>>>>> branch-Level-9
    public static void printLoadingError() {
        System.out.println("Hah, even I can't load this file? Must be cursed!");
    }

    /**
     * Prints a message for unknown or invalid user commands.
     */
    public static void printUnknownCommandMessage() {
        System.out.println("OOPS~! You've officially confused even me! Try again, maybe with actual commands?");
    }
}
