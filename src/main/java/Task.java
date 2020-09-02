public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this(description, false);
    }

    public Task(String description, Boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * getStatusIcon pretty prints format
     *
     * @return status as tick/cross string
     */
    public String getStatusIcon() {
        return (this.isDone ? "\u2713" : "\u2718");
    }

    /**
     * markAsDone marks task instance as completed
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * toString overrides superclass string method
     *
     * @return task status and description
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), this.description);
    }
}
