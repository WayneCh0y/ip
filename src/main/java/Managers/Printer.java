package Managers;

import TaskItems.Task;

import java.util.List;

public class Printer {
    private static final String LINE_SEPARATOR = "____________________________________________________________";

    public static void chatbotGreeting() {
        printLine();
        System.out.println("Hey there! The name's Gojo. The strongest sorcerer you'll ever meet.");
        System.out.println("What can I do for you?");
        printLine();
    }

    public static void end() {
        System.out.println("Bye! Don't miss me too much, okay?");
        printLine();
    }

    public static void printLine() {
        System.out.println(LINE_SEPARATOR);
    }

    public static void printIndexNumber(int index) {
        System.out.print((index + 1) + ". ");
    }

    public static void printEntry(Task task) {
        System.out.println(task);
    }

    public static void printMarkResult(Task task) {
        printLine();
        System.out.println("Awesome! Task marked as completed:");
        printEntry(task);
        printLine();
    }

    public static void printUnmarkResult(Task task) {
        printLine();
        System.out.println("Okay, I've marked this as not done yet. Guess even perfection takes a little time huh?:");
        printEntry(task);
        printLine();
    }

    public static void printTaskAdded(int listSize, Task task) {
        Printer.printLine();
        System.out.println("Got it! Task added.");
        System.out.println(task);
        printListSize(listSize);
        Printer.printLine();
    }

    private static void printListSize(int listSize) {
        System.out.println("Now you have " + listSize + " tasks in the list.");
    }

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

    public static void printDeleteResult(List<Task> taskList, Task task) {
        int index = 0;
        Printer.printLine();
        System.out.println("Ah, I see what you did there! Was that a sneaky Gojo-style move to make the task disappear?");
        printEntry(task);
        printListSize(taskList.size());
        Printer.printLine();
    }
}
