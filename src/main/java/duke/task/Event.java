package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate at;

    public Event(String description, LocalDate at) {
        super(description);
        this.at = at;
    }

    /**
     * toString overrides superclass string method
     *
     * @return task status and description
     */
    @Override
    public String toString() {
        return String.format(
                "[E]%s (at: %s)",
                super.toString(),
                this.at.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))
        );
    }

    /**
     * overridees superclass string method
     *
     * @return completed and event in its input format
     * eg false event lecture /at 2020-10-01
     */
    @Override
    public String toInputString() {
        return String.format(
                "%s event %s /at %s",
                super.toInputString(), this.description, this.at
        );
    }
}
