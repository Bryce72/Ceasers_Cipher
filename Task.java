import java.util.Comparator;
import java.util.Objects;

public class Task{
    private String description;
    private Date date;
    private boolean completed = false;
    private Priority priority;



    public Task(String description, Date date, Priority priority) {
        this.description = description;
        this.date = date;
        this.priority = priority;
    }
    @Override
    public int hashCode(){
        return Objects.hash(description, date, priority);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) {return true;}
        if(o == null || getClass() != o.getClass()) {return false;}

        Task task = (Task) o;
        return Objects.equals(description, task.getDescription()) && Objects.equals(date, task.getDate()) && priority == task.getPriority();
    }





    //setters
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void completed(boolean isCompleted) {
        this.completed = isCompleted;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    // making my getters
    public String getDescription() {
        return this.description;
    }
    public Date getDate() {
        return this.date;
    }
    public boolean getCompleted() {
        return this.completed;
    }
    public Priority getPriority() {
        return this.priority;
    }

// for objective 4
    public static final Comparator<Task> PRIORITY_COMPARATOR = (t1, t2) -> t1.getPriority().compareTo(t2.getPriority());

}
