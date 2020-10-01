package duke.io;

import duke.task.Task;

import java.util.ArrayList;

public class Ui {
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

    public void showLine(boolean breakLine) {
        System.out.print(HR);
        if (breakLine) {
            System.out.println();
        }
    }

    public void showLine() {
        this.showLine(false);
    }

    public void showGreet() {
        System.out.print(GREET);
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showBye() {
        System.out.print(BYE);
    }

    public void showEcho(String message) {
        System.out.print(String.format(ECHO, message));
    }

    public void showList(ArrayList<Task> tasks) {
        System.out.println("     Here are the tasks in your list:");
        for (int i = 1; i <= tasks.size(); ++i) {
            System.out.print(String.format(TASK, i, tasks.get(i - 1)));
        }
    }

    public void showDone(Task task) {
        System.out.print(String.format(DONE, task));
    }

    public void showDelete(Task task, int size) {
        System.out.print(String.format(DELETE, task, size));
    }

    public void showAdd(Task task, int size) {
        System.out.print(String.format(ADD, task, size));
    }
}
