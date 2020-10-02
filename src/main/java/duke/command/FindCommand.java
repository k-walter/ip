package duke.command;

import duke.io.Storage;
import duke.io.Ui;
import duke.task.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FindCommand extends Command {
    protected String match;

    public FindCommand(String match) {
        this.match = match;
    }

    /**
     * Filters all tasks on match string
     *
     * @param tasks   to be filtered
     * @param ui
     * @param storage
     * @throws IOException
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws IOException {
        ArrayList<Task> result = (ArrayList<Task>) tasks.stream()
                .filter(task -> task.contains(this.match))
                .collect(Collectors.toList());
        ui.showFind(result);
    }
}
