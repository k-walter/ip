package duke;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    protected static final String HR = "    ____________________________________________________________\n";
    protected static final String GREET = "     Hello! I'm Duke\n" +
            "     What can I do for you?\n";
    protected static final String BYE = "     Bye. Hope to see you again soon!\n";
    protected static final String ECHO = "     %s\n";
    protected static final String ADD = "     Got it. I've added this task: \n" +
            "       %s\n" +
            "     Now you have %d tasks in the list.\n";
    protected static final String TASK = "     %d. %s\n";
    protected static final String DONE = "     Nice! I've marked this task as done: \n" +
            "       %s\n";

    protected static ArrayList<Task> tasks = new ArrayList<>(100);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String stdIn = "greet";
        String stdOut = "";

        do {
            try {
                stdOut = parseCmd(stdIn);
            } catch (UnknownArgumentException e) {
                stdOut = e.toString();
            } catch (EmptyArgumentException e) {
                stdOut = e.toString();
            } catch (NumberFormatException e) {
                stdOut = e.toString();
            } catch (IndexOutOfBoundsException e) {
                stdOut = e.toString();
            } catch (Exception e) {
                stdOut = e.toString();
            } finally {
                System.out.println(HR + stdOut + HR);
            }

            stdIn = scan.nextLine();
        } while (!stdIn.equals("bye"));

        System.out.println(BYE);
    }

    protected static String parseCmd(String line) throws EmptyArgumentException, UnknownArgumentException {
        // Take commands from first space-separated word
        String[] cmd = line.split(" ");
        if (cmd.length == 0) {
            throw new EmptyArgumentException("command");
        }

        switch (cmd[0]) {

        case "greet": {
            return GREET;
        }

        case "echo": {
            String statement = joinUntil(cmd, 1, cmd.length);
            return String.format(ECHO, statement);
        }

        case "list": {
            StringBuilder out = new StringBuilder("     Here are the tasks in your list:\n");
            for (int i = 1; i <= tasks.size(); ++i) {
                out.append(String.format(TASK, i, tasks.get(i - 1)));
            }
            return out.toString();
        }

        case "done": {
            int i = Integer.parseInt(cmd[1]);
            tasks.get(i - 1).markAsDone();
            return String.format(DONE, tasks.get(i - 1));
        }

        case "todo": {
            if (cmd.length <= 1) {
                throw new EmptyArgumentException("todo");
            }
            String description = joinUntil(cmd, 1, cmd.length);
            Todo t = new Todo(description);
            return addTask(t);
        }

        case "deadline": {
            int i = indexOfString(cmd, "/by");
            String description = joinUntil(cmd, 1, i);
            String by = joinUntil(cmd, i + 1, cmd.length);
            Deadline d = new Deadline(description, by);
            return addTask(d);
        }

        case "event": {
            int i = indexOfString(cmd, "/at");
            String description = joinUntil(cmd, 1, i);
            String at = joinUntil(cmd, i + 1, cmd.length);
            Event e = new Event(description, at);
            return addTask(e);
        }

        default: {
            throw new UnknownArgumentException();
        }
        }
    }

    /**
     * addTask adds task to array and prints total number of tasks
     *
     * @param task - to be added
     */
    public static String addTask(Task task) {
        tasks.add(task);
        return String.format(ADD, task, tasks.size());
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
