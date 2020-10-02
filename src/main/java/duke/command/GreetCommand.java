package duke.command;

import duke.io.Storage;
import duke.io.Ui;
import duke.task.Task;

import java.util.ArrayList;

public class GreetCommand extends Command {
    /**
     * Greets Duke user
     *
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        ui.showGreet();
    }
}
