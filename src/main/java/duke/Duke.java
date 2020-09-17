package duke;

import duke.error.EmptyArgumentException;
import duke.error.UnknownArgumentException;
import duke.io.TaskFile;
import duke.io.Util;
import duke.task.Task;

import java.io.IOException;
import java.util.ArrayList;
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
    protected static final String DELETE = "     Noted. I've removed this task: \n" +
            "       %s\n" +
            "     Now you have %d tasks in the list.\n";

    protected static ArrayList<Task> tasks;

    public static void main(String[] args) throws IOException {
        // Read or instantiate file
        try {
            tasks = TaskFile.readFile();
        } catch (Exception e) {
            System.out.println(e);
            TaskFile.initFile();
            tasks = new ArrayList<>();
        }

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
            } catch (IOException e) {
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

    protected static String parseCmd(String line) throws EmptyArgumentException, UnknownArgumentException, IOException {
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
            String statement = Util.joinUntil(cmd, 1, cmd.length);
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
            TaskFile.writeFile(tasks);
            return String.format(DONE, tasks.get(i - 1));
        }

        case "delete": {
            int i = Integer.parseInt(cmd[1]) - 1;
            Task t = tasks.get(i);
            tasks.remove(i);
            TaskFile.writeFile(tasks);
            return String.format(DELETE, t, tasks.size());
        }

        case "todo":
        case "deadline":
        case "event":
            return addTask(Task.parseCmd(cmd));

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
    public static String addTask(Task task) throws IOException {
        tasks.add(task);
        TaskFile.writeFile(tasks);
        return String.format(ADD, task, tasks.size());
    }

}
