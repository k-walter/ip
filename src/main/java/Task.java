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
     * getStatusIcon returns tick/cross icon corresponding to the task's completion status
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
     * getStatus returns formatted task status and description
     */
    public String getStatus() {
        return String.format("[%s] %s", this.getStatusIcon(), this.description);
    }
}
