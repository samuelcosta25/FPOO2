public class Task {
    // atributos
    String description;
    boolean done;
    boolean removed;

    // cosntrutor
    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    // gets sets
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

}
