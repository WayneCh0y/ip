import java.util.Scanner;
import java.util.*;

public class Gojo {
    public static void printList(List<Task> listItems) {
        int index = 0;
        System.out.println("____________________________________________________________");
        System.out.println("Alright, here's the lineup of tasks on your list! Let's breeze through them.");
        for (Task items : listItems) {
            System.out.print((index + 1) + ". ");
            System.out.print("[" + items.getStatusIcon() + "] ");
            System.out.println(items.getDescription());
            index++;
        }
        System.out.println("____________________________________________________________");
    }

    public static void markAsDone(List<Task> list, String line) {
        int index = line.indexOf(" ");
        String number = line.substring(index + 1);
        int num = Integer.parseInt(number) - 1;

        if (num >= list.size() || num < 0 || list.get(num).getStatus()) {
            return;
        }

        System.out.println("____________________________________________________________");
        System.out.println("Awesome! Task marked as completed:");
        list.get(num).markAsDone();
        System.out.println("[" + list.get(num).getStatusIcon() + "] " + list.get(num).getDescription());
        System.out.println("____________________________________________________________");
    }

    public static void unmarkAsDone(List<Task> list, String line) {
        int index = line.indexOf(" ");
        String number = line.substring(index + 1);
        int num = Integer.parseInt(number) - 1;

        if (num >= list.size() || num < 0 || !list.get(num).getStatus()) {
            return;
        }

        System.out.println("____________________________________________________________");
        System.out.println("Okay, I've marked this as not done yet. Guess even perfection takes a little time huh?:");
        list.get(num).unmarkAsDone();
        System.out.println("[" + list.get(num).getStatusIcon() + "] " + list.get(num).getDescription());
        System.out.println("____________________________________________________________");
    }

    public static boolean findMark(String[] words) {
        for (String word : words) {
            if (word.equals("mark")) {
                return true;
            }
        }
        return false;
    }

    public static boolean findUnmark(String[] words) {
        for (String word : words) {
            if (word.equals("unmark")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String line;
        List<Task> listItems = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("____________________________________________________________");
        System.out.println("Hey there! The name's Gojo. The strongest sorcerer you'll ever meet.");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

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
            System.out.println("____________________________________________________________");
            System.out.println("added: " + line);
            listItems.add(task);
            System.out.println("____________________________________________________________");
        }
        System.out.println("Bye! Don't miss me too much, okay?");
        System.out.println("____________________________________________________________");
    }
}
