package duke.error;

public class EmptyArgumentException extends Exception {
    String descriptor;

    public EmptyArgumentException() {
        this("");
    }

    public EmptyArgumentException(String descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public String toString() {
        return String.format(
                "     ☹ OOPS!!! The description of a %s cannot be empty.\n",
                this.descriptor
        );
    }
}
