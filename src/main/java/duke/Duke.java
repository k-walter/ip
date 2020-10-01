package duke;

import duke.command.Command;
import duke.io.Storage;
import duke.io.Ui;
import duke.task.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    protected static ArrayList<Task> tasks;
    protected static Storage storage;
    protected static Ui ui;

    public Duke(String path) {
        ui = new Ui();
        try {
            storage = new Storage(path);
            tasks = Storage.readFile();
        } catch (Exception e) {
            System.out.println(e);
            tasks = new ArrayList<>();
        }
    }

    public static void run() {
        Scanner scan = new Scanner(System.in);
        String stdIn = "greet";

        do {
            try {
                Command c = Command.parse(stdIn);
                ui.showLine();
                c.execute(tasks, ui, storage);
            } catch (Exception e) {
                ui.showError(e.toString());
            } finally {
                ui.showLine(true);
            }

            stdIn = scan.nextLine();
        } while (!stdIn.equals("bye"));

        ui.showBye();
    }

    public static void main(String[] args) throws IOException {
        new Duke("data/duke.txt").run();
    }
}
