package duke.command;

import duke.io.Storage;
import duke.io.Ui;
import duke.task.Task;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteCommand extends Command {
    protected int i;

    public DeleteCommand(int i) {
        this.i = i;
    }

    /**
     * Remove task from array with index and displays confirmation message
     *
     * @param tasks   to remove task from
     * @param ui
     * @param storage to store resultant tasks
     * @throws IOException
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws IOException {
        Task t = tasks.get(this.i);
        tasks.remove(this.i);
        Storage.writeFile(tasks);
        ui.showDelete(t, tasks.size());
    }
}
