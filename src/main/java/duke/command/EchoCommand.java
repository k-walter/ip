package duke.command;

import duke.io.Storage;
import duke.io.Ui;
import duke.task.Task;

import java.util.ArrayList;

public class EchoCommand extends Command {
    protected String message;

    public EchoCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        ui.showEcho(this.message);
    }
}
