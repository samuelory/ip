package OGFTask;

/**
 * Class for to do tasks
 */
public class Todo extends Task {
    public Todo(String task){
        super(task);
    }

    public Todo(String task, boolean isDone){
        super(task, isDone);
    }
    @Override
    public String toString(){
        if (this.isDone){
            return("[T][X] " + this.taskName);
        }
        else{
            return("[T][ ] " + this.taskName);
        }
    }

    @Override
    public String toSerial() {
        return ("todo,"+ super.toSerial());
    }
}
