package duke.command;

import duke.io.Storage;
import duke.io.Ui;
import duke.task.Task;

import java.util.ArrayList;

public class ListCommand extends Command {
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        ui.showList(tasks);
    }
}
