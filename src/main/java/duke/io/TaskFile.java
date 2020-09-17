package duke.io;

import duke.error.EmptyArgumentException;
import duke.error.UnknownArgumentException;
import duke.task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskFile {
    protected static File f = new File("data/duke.txt");

    public static void initFile() throws IOException {
        if (f.exists()) {
            return;
        }
        f.getParentFile().mkdirs();
        f.createNewFile();
    }

    public static void writeFile(ArrayList<Task> array) throws IOException {
        FileWriter fw = new FileWriter(f, false);
        for (Task t : array) {
            fw.write(t.toInputString() + "\n");
        }
        fw.close();
    }

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
