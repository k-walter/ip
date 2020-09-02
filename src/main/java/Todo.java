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
}
