package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate by;

    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    /**
     * toString overrides superclass string method
     *
     * @return task status and description
     */
    @Override
    public String toString() {
        return String.format(
                "[D]%s (by: %s)",
                super.toString(),
                this.by.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))
        );
    }

    @Override
    public String toInputString() {
        return String.format(
                "%s deadline %s /by %s",
                super.toInputString(), this.description, this.by
        );
    }
}
