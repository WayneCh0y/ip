import java.util.Scanner;
import java.util.*;

public class Gojo {

    public static final String LINE_SEPARATER = "____________________________________________________________";
    public static final int MIN_LENGTH_MARK = 6;
    public static final int MIN_LENGTH_UNMARK = 8;

    public static void printList(List<Task> listItems) {
        int index = 0;
        System.out.println(LINE_SEPARATER);
        System.out.println("Alright, here's the lineup of tasks on your list! Let's breeze through them.");
        for (Task items : listItems) {
            printIndexNumber(index);
            printEntry(items);
            index++;
        }
        System.out.println(LINE_SEPARATER);
    }

    public static void printBox(Task items) {
        System.out.print("[" + items.getStatusIcon() + "] ");
    }

    public static void printIndexNumber(int index) {
        System.out.print((index + 1) + ". ");
    }

    public static void printItemDescription(Task items) {
        System.out.println(items.getDescription());
    }

    public static boolean lineIsTooShort(String line, int len) {
        return line.length() < len;
    }


    public static void markAsDone(List<Task> list, String line) {
        if (lineIsTooShort(line, MIN_LENGTH_MARK)) {
            return;
        }

        int num = getNum(line);

        if (isValidToMark(list, num)) {
            return;
        }

        printMarkResult(list, num);
    }

    private static boolean isValidToMark(List<Task> list, int num) {
        return num >= list.size() || num < 0 || list.get(num).getStatus();
    }

    private static void printMarkResult(List<Task> list, int num) {
        System.out.println(LINE_SEPARATER);
        System.out.println("Awesome! Task marked as completed:");
        list.get(num).markAsDone();
        printEntry(list.get(num));
        System.out.println(LINE_SEPARATER);
    }

    private static int getNum(String line) {
        String[] words = line.split(" ");
        String number = words[1];
        return Integer.parseInt(number) - 1;
    }

    private static void printEntry(Task list) {
        printBox(list);
        printItemDescription(list);
    }

    public static void unmarkAsDone(List<Task> list, String line) {
        if (lineIsTooShort(line, MIN_LENGTH_UNMARK)) {
            return;
        }

        int num = getNum(line);

        if (isValidToUnmark(list, num)) {
            return;
        }

        printUnmarkResult(list, num);
    }

    private static boolean isValidToUnmark(List<Task> list, int num) {
        return num >= list.size() || num < 0 || !list.get(num).getStatus();
    }

    private static void printUnmarkResult(List<Task> list, int num) {
        System.out.println(LINE_SEPARATER);
        System.out.println("Okay, I've marked this as not done yet. Guess even perfection takes a little time huh?:");
        list.get(num).unmarkAsDone();
        printEntry(list.get(num));
        System.out.println(LINE_SEPARATER);
    }

    public static boolean findMark(String[] words) {
        if (words[0].equals("mark")) {
            return true;
        }
        return false;
    }

    public static boolean findUnmark(String[] words) {
        if (words[0].equals("unmark")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String line;
        List<Task> listItems = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        chatbotGreeting();
        start(in, listItems);
        end();
    }

    private static void end() {
        System.out.println("Bye! Don't miss me too much, okay?");
        System.out.println(LINE_SEPARATER);
    }

    private static void chatbotGreeting() {
        System.out.println(LINE_SEPARATER);
        System.out.println("Hey there! The name's Gojo. The strongest sorcerer you'll ever meet.");
        System.out.println("What can I do for you?");
        System.out.println(LINE_SEPARATER);
    }

    private static void start(Scanner in, List<Task> listItems) {
        String line;
        while(true) {
            line = in.nextLine();

            if (line.equals("bye")) {
                break;
            }
            if (line.equals("list")) {
                printList(listItems);
                continue;
            }

            String[] words = line.split(" ");
            if (findMark(words)) {
                markAsDone(listItems, line);
                continue;
            }
            if (findUnmark(words)) {
                unmarkAsDone(listItems, line);
                continue;
            }

            Task task = new Task(line);
            System.out.println(LINE_SEPARATER);
            System.out.println("added: " + line);
            listItems.add(task);
            System.out.println(LINE_SEPARATER);
        }
    }
}
