import TaskItems.Task;

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
        System.out.println("Now you have " + listSize + " tasks in the list.");
        Printer.printLine();
    }
}
