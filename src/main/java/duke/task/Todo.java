package duke.task;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    /**
     * toString overrides superclass string method
     *
     * @return task status and description
     */
    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }

    @Override
    public String toInputString() {
        return String.format(
                "%s todo %s",
                super.toInputString(), this.description
        );
    }
}
