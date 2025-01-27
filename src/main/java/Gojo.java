import java.util.Scanner;

public class Gojo {
    public static void main(String[] args) {
        String line;
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
            System.out.println("____________________________________________________________");
            System.out.println(line);
            System.out.println("____________________________________________________________");
        }
        System.out.println("Bye! Don't miss me too much, okay?");
        System.out.println("____________________________________________________________");
    }
}
