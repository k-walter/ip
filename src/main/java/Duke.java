import java.util.Scanner;

public class Duke {
    private static String greet = "    ____________________________________________________________\n" +
            "     Hello! I'm Duke\n" +
            "     What can I do for you?\n" +
            "    ____________________________________________________________\n";

    private static String bye = "    ____________________________________________________________\n" +
            "     Bye. Hope to see you again soon!\n" +
            "    ____________________________________________________________\n";

    private static String echo = "    ____________________________________________________________\n" +
            "     %s\n" +
            "    ____________________________________________________________\n";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = "greet";

        do {
           switch (line) {
               case "greet":
                   System.out.println(greet);
                   break;
               default:
                   System.out.println(String.format(echo, line));
           }

           line = scan.nextLine();
        } while (!line.equals("bye")) {

        System.out.println(bye);
    }
}
