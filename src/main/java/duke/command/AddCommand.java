package duke.command;

import duke.io.Storage;
import duke.io.Ui;
import duke.task.Task;

import java.io.IOException;
import java.util.ArrayList;

public class AddCommand extends Command {
    protected Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    /**
     * adds task to array and prints total number of tasks
     *
     * @param task - to be added
     */
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws IOException {
        tasks.add(this.task);
        Storage.writeFile(tasks);
        ui.showAdd(this.task, tasks.size());
    }
}
