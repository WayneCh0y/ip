import java.util.List;

public class Printer {
    private static final String LINE_SEPARATER = "____________________________________________________________";

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
        System.out.println(LINE_SEPARATER);
    }

    public static void printList(List<Task> listItems) {
        int index = 0;
        printLine();
        System.out.println("Alright, here's the lineup of tasks on your list! Let's breeze through them.");
        for (Task items : listItems) {
            printIndexNumber(index);
            printEntry(items);
            index++;
        }
        printLine();
    }

    public static void printIndexNumber(int index) {
        System.out.print((index + 1) + ". ");
    }

    public static void printEntry(Task list) {
        System.out.println(list);
    }

    public static void printMarkResult(List<Task> list, int numToMark) {
        printLine();
        System.out.println("Awesome! Task marked as completed:");
        printEntry(list.get(numToMark));
        printLine();
    }

    public static void printUnmarkResult(List<Task> list, int num) {
        printLine();
        System.out.println("Okay, I've marked this as not done yet. Guess even perfection takes a little time huh?:");
        list.get(num).unmarkAsDone();
        printEntry(list.get(num));
        printLine();
    }

    public static void printTaskAdded(List<Task> listItems, Task eventTask) {
        Printer.printLine();
        System.out.println("Got it! Task added.");
        System.out.println(eventTask);
        listItems.add(eventTask);
        System.out.println("Now you have " + listItems.size() + " tasks in the list.");
        Printer.printLine();
    }
}
