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

    /**
     * overridees superclass string method
     *
     * @return completed and task in its input format
     * eg false todo assignment
     */
    @Override
    public String toInputString() {
        return String.format(
                "%s todo %s",
                super.toInputString(), this.description
        );
    }
}
