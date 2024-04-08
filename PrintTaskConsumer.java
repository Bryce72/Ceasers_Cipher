import java.util.function.Consumer;
public class PrintTaskConsumer implements Consumer<Task>{
    @Override
    public void accept(Task task) {
        System.out.println("Task: " + task.getDescription() + ", Due:  "+ task.getDate().getMonth() +"/" + task.getDate().getDay() + "/" + task.getDate().getYear() + ", Priority: " + task.getPriority());
    }
}
