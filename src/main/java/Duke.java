import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    protected static final String hr = "    ____________________________________________________________\n";
    protected static final String greet = hr +
            "     Hello! I'm Duke\n" +
            "     What can I do for you?\n" +
            hr;
    protected static final String bye = hr +
            "     Bye. Hope to see you again soon!\n" +
            hr;
    protected static final String echo = hr +
            "     %s\n" +
            hr;
    protected static final String add = hr +
            "     Got it. I've added this task: \n" +
            "       %s\n" +
            "     Now you have %d tasks in the list.\n" +
            hr;
    protected static final String task = "     %d. %s";
    protected static final String done = hr +
            "     Nice! I've marked this task as done: \n" +
            "       %s\n" +
            hr;

    protected static ArrayList<Task> tasks = new ArrayList<>(100);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = "greet";

        do {
            // Take commands from first space-separated word
            String[] cmd = line.split(" ");
            switch (cmd[0]) {

            case "greet": {
                System.out.println(greet);
                break;
            }

            case "echo": {
                String statement = joinUntil(cmd, 1, cmd.length);
                System.out.println(String.format(echo, statement));
                break;
            }

            case "list": {
                System.out.print(hr + "     Here are the tasks in your list:\n");
                for (int i = 1; i <= tasks.size(); ++i) {
                    System.out.println(String.format(task, i, tasks.get(i - 1)));
                }
                System.out.println(hr);
                break;
            }

            case "done": {
                int i = Integer.parseInt(cmd[1]);
                tasks.get(i - 1).markAsDone();
                System.out.println(String.format(done, tasks.get(i - 1)));
                break;
            }

            case "todo": {
                String description = joinUntil(cmd, 1, cmd.length);
                Todo t = new Todo(description);
                addTask(t);
                break;
            }

            case "deadline": {
                int i = indexOfString(cmd, "/by");
                String description = joinUntil(cmd, 1, i);
                String by = joinUntil(cmd, i + 1, cmd.length);
                Deadline d = new Deadline(description, by);
                addTask(d);
                break;
            }

            case "event": {
                int i = indexOfString(cmd, "/at");
                String description = joinUntil(cmd, 1, i);
                String at = joinUntil(cmd, i + 1, cmd.length);
                Event e = new Event(description, at);
                addTask(e);
                break;
            }

            default: {
                Task t = new Task(line);
                addTask(t);
                break;
            }
            }

            line = scan.nextLine();
        } while (!line.equals("bye"));

        System.out.println(bye);
    }

    /**
     * addTask adds task to array and prints total number of tasks
     *
     * @param task - to be added
     */
    public static void addTask(Task task) {
        tasks.add(task);
        System.out.println(String.format(add, task, tasks.size()));
    }

    /**
     * indexofString searches matching string within the array
     *
     * @param array - to search within
     * @param match - to be searched
     * @return index of matched string, or -1 if not found
     */
    public static int indexOfString(String[] array, String match) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i].equals(match)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * joinUntil joins array of string into string
     *
     * @param join - array of string to join
     * @param from - start index to join from
     * @param to   - end index to join up to
     * @return joined string
     */
    public static String joinUntil(String[] join, int from, int to) {
        String[] stringArray = Arrays.copyOfRange(join, from, to);
        return String.join(" ", stringArray);
    }
}
