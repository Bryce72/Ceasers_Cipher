import java.util.function.Function;
public class TaskToString implements Function<Task, String> {

    // need something to convert my months to string the way i want it
    private static final String[] MONTH_NAMES = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };
    @Override
    public String apply(Task task) {
        String monthName = MONTH_NAMES[task.getDate().getMonth() - 1];
        // Since I am dealing with multiple datatypes within Task, I need to be careful to return what is needed
        return "Task: " + task.getDescription() + ", Due: " + monthName + " " + task.getDate().getDay() + ", " + task.getDate().getYear() + ", Priority: " + task.getPriority();
    }
}
