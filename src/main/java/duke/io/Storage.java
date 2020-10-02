package duke.io;

import duke.error.EmptyArgumentException;
import duke.error.UnknownArgumentException;
import duke.task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    protected static File f;

    /**
     * Opens file or initialises file if not existing
     *
     * @param path
     * @throws IOException
     */
    public Storage(String path) throws IOException {
        f = new File(path);
        if (f.exists()) {
            return;
        }
        f.getParentFile().mkdirs();
        f.createNewFile();
    }

    /**
     * Writes array of tasks to file
     *
     * @param array of Task subclasses
     * @throws IOException
     */
    public static void writeFile(ArrayList<Task> array) throws IOException {
        FileWriter fw = new FileWriter(f, false);
        for (Task t : array) {
            fw.write(t.toInputString() + "\n");
        }
        fw.close();
    }

    /**
     * Reads array of tasks from file
     *
     * @return array of Task subclasses
     * @throws IOException
     * @throws EmptyArgumentException
     * @throws UnknownArgumentException
     */
    public static ArrayList<Task> readFile() throws IOException, EmptyArgumentException, UnknownArgumentException {
        Scanner s = new Scanner(f);
        ArrayList<Task> array = new ArrayList<>();
        while (s.hasNext()) {
            Task t = Task.parseCmd(s.nextLine());
            array.add(t);
        }
        return array;
    }
}
