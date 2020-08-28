import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    private static String hr = "    ____________________________________________________________\n";
    private static String greet = hr +
            "     Hello! I'm Duke\n" +
            "     What can I do for you?\n" +
            hr;
    private static String bye = hr +
            "     Bye. Hope to see you again soon!\n" +
            hr;
    private static String echo = hr +
            "     %s\n" +
            hr;
    private static String add = hr +
            "     added: %s\n" +
            hr;
    private static String task = "     %d. %s";
    private static String done = hr +
            "     Nice! I've marked this task as done: \n" +
            "       %s\n" +
            hr;

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String line = "greet";

        do {
            // Take commands from first space-separated word
            String[] cmd = line.split(" ");
            switch (cmd[0]) {

            case "greet":
                System.out.println(greet);
                break;

            case "echo":
                String[] statementArray = Arrays.copyOfRange(cmd, 1, cmd.length);
                String statement = String.join(" ", statementArray);
                System.out.println(String.format(echo, statement));
                break;

            case "list":
                System.out.print(hr);
                for (int i = 1; i <= tasks.size(); ++i) {
                    System.out.println(String.format(task, i, tasks.get(i - 1).getStatus()));
                }
                System.out.println(hr);
                break;

            case "done":
                int i = Integer.parseInt(cmd[1]);
                tasks.get(i - 1).markAsDone();
                System.out.println(String.format(done, tasks.get(i - 1).getStatus()));
                break;

            default:
                Task t = new Task(line);
                tasks.add(t);
                System.out.println(String.format(add, line));
                break;
            }

            line = scan.nextLine();
        } while (!line.equals("bye"));

        System.out.println(bye);
    }
}
