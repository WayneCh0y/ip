import java.util.Scanner;
import java.util.*;

public class Gojo {
    public static void printList(List<String> listItems) {
        int index = 0;
        System.out.println("____________________________________________________________");
        for (String items : listItems) {
            System.out.println((index + 1) + ". " + items);
            index++;
        }
        System.out.println("____________________________________________________________");
    }
    public static void main(String[] args) {
        String line;
        List<String> listItems = new ArrayList<>();
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
            System.out.println("____________________________________________________________");
            System.out.println("added: " + line);
            listItems.add(line);
            System.out.println("____________________________________________________________");
        }
        System.out.println("Bye! Don't miss me too much, okay?");
        System.out.println("____________________________________________________________");
    }
}
