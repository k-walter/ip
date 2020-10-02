package duke.command;

import duke.io.Storage;
import duke.io.Ui;
import duke.task.Task;

import java.io.IOException;
import java.util.ArrayList;

public class DoneCommand extends Command {
    protected int i;

    public DoneCommand(int i) {
        this.i = i;
    }

    /**
     * Marks task as done with index and displays confirmation message
     *
     * @param tasks   to be marked as done
     * @param ui
     * @param storage to store resultant tasks
     * @throws IOException
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws IOException {
        tasks.get(this.i - 1).markAsDone();
        Storage.writeFile(tasks);
        ui.showDone(tasks.get(this.i - 1));
    }
}
