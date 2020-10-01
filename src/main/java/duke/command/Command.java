package duke.command;

import duke.common.Util;
import duke.error.EmptyArgumentException;
import duke.error.UnknownArgumentException;
import duke.io.Storage;
import duke.io.Ui;
import duke.task.Task;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Command {
    /**
     * Parses single line command given given space-separated parameters
     *
     * @param line to be parsed
     * @return respective Command subclass to be executed
     * @throws EmptyArgumentException
     * @throws UnknownArgumentException
     * @throws IOException
     */
    public static Command parse(String line) throws EmptyArgumentException, UnknownArgumentException, IOException {
        // Take commands from first space-separated word
        String[] cmd = line.split(" ");
        if (cmd.length == 0) {
            throw new EmptyArgumentException("command");
        }

        switch (cmd[0]) {

        case "greet": {
            return new GreetCommand();
        }

        case "echo": {
            String statement = Util.joinUntil(cmd, 1, cmd.length);
            return new EchoCommand(statement);
        }

        case "list": {
            return new ListCommand();
        }

        case "done": {
            int i = Integer.parseInt(cmd[1]);
            return new DoneCommand(i);
        }

        case "delete": {
            int i = Integer.parseInt(cmd[1]) - 1;
            return new DeleteCommand(i);
        }

        case "find": {
            String match = Util.joinUntil(cmd, 1, cmd.length);
            return new FindCommand(match);
        }

        case "todo":
        case "deadline":
        case "event":
            return new AddCommand(Task.parseCmd(cmd));

        default: {
            throw new UnknownArgumentException();
        }
        }
    }

    /**
     * Enforces implementation for all commands
     *
     * @param tasks   array to be referenced
     * @param ui      methods to call for display
     * @param storage to read and write to file
     * @throws IOException
     */
    public abstract void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws IOException;
}