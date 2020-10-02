package duke.task;

import duke.common.Util;
import duke.error.EmptyArgumentException;
import duke.error.UnknownArgumentException;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this(description, false);
    }

    public Task(String description, Boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * parses single command from stored data
     *
     * @param cmd space-separated string commands
     * @return respective Task subclass
     * @throws EmptyArgumentException
     * @throws UnknownArgumentException
     */
    public static Task parseCmd(String cmd) throws EmptyArgumentException, UnknownArgumentException {
        String[] input = cmd.split(" ");
        if (input.length < 2) {
            throw new UnknownArgumentException();
        }

        boolean isDone = Boolean.parseBoolean(input[0]);
        String[] cmdArray = Arrays.copyOfRange(input, 1, input.length);
        Task t = parseCmd(cmdArray);
        if (isDone) {
            t.markAsDone();
        }
        return t;
    }

    /**
     * parses single command from CLI
     *
     * @param cmd space-separated string commands
     * @return respective Task subclass
     * @throws EmptyArgumentException
     * @throws UnknownArgumentException
     */
    public static Task parseCmd(String[] cmd) throws EmptyArgumentException, UnknownArgumentException {
        if (cmd.length <= 1) {
            String cmdType = cmd.length == 1 ? cmd[0] : "";
            throw new EmptyArgumentException(cmdType);
        }

        switch (cmd[0]) {
        case "todo": {
            String description = Util.joinUntil(cmd, 1, cmd.length);
            return new Todo(description);
        }

        case "deadline": {
            int i = Util.indexOfString(cmd, "/by");
            String description = Util.joinUntil(cmd, 1, i);
            String by = Util.joinUntil(cmd, i + 1, cmd.length);
            LocalDate d = LocalDate.parse(by);
            return new Deadline(description, d);
        }

        case "event": {
            int i = Util.indexOfString(cmd, "/at");
            String description = Util.joinUntil(cmd, 1, i);
            String at = Util.joinUntil(cmd, i + 1, cmd.length);
            LocalDate d = LocalDate.parse(at);
            return new Event(description, d);
        }

        default:
            throw new UnknownArgumentException();
        }
    }

    /**
     * contains searches for match within description
     *
     * @param match to be found
     * @return if description contains matching string
     */
    public boolean contains(String match) {
        return this.description.contains(match);
    }

    /**
     * markAsDone marks task instance as completed
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * getStatusIcon pretty prints format
     *
     * @return status as tick/cross string
     */
    public String getStatusIcon() {
        return (this.isDone ? "\u2713" : "\u2718");
    }

    /**
     * toString overrides superclass string method
     *
     * @return task status and description
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), this.description);
    }

    /**
     * overridees superclass string method
     *
     * @return completed and task in its input format
     */
    public String toInputString() {
        return Boolean.toString(this.isDone);
    }
}
