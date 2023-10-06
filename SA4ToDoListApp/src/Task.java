public class Task {
    //atributos
    String description;
    boolean done;
    //cosntrutor
    public Task(String description) {
        this.description = description;
        this.done = false;
    }
    //gets sets
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
    
    
}
