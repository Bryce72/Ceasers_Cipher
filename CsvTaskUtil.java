import java.io.*;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.nio.file.Path;

public class CsvTaskUtil {
    //need to format my csv date


    // load csv file:
    public static List<Task> loadTasksFromCSV(String filename) throws IOException {
        List<Task> tasks = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); //need to skil the headers

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                String[] dateParts = values[1].split("-");
                // should format date to : YYYY-MM-DD
                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]) - 1;
                int day = Integer.parseInt(dateParts[2]);
                Date date = new Date(day, month, year);

                //description, date, priority
                Task task = new Task(values[0].replace("\"", ""), date, Priority.valueOf(values[2].trim()));
                tasks.add(task);
            }
        }
        return tasks;
    }


    // save to csv
    public static void saveToCSV(List<Task> tasks, String filename)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("description,Date,Priority");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for(Task task : tasks)
        {
            sb.append(task.getDescription()).append(",").append(task.getDate()).append(",").append(task.getPriority()).append("\n");
        }

        try{
            Files.writeString(Path.of(filename), sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
