package duke.io;

import java.util.Arrays;

public class Util {
    /**
     * indexofString searches matching string within the array
     *
     * @param array - to search within
     * @param match - to be searched
     * @return index of matched string, or -1 if not found
     */
    public static int indexOfString(String[] array, String match) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i].equals(match)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * joinUntil joins array of string into string
     *
     * @param join - array of string to join
     * @param from - start index to join from
     * @param to   - end index to join up to
     * @return joined string
     */
    public static String joinUntil(String[] join, int from, int to) {
        String[] stringArray = Arrays.copyOfRange(join, from, to);
        return String.join(" ", stringArray);
    }
}
