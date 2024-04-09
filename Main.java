import java.io.IOException;
import java.util.*;



public class Main {
    public static void main(String[] args) {

        /*
        // making my dates
        Date thisWeekend = new Date(30, 3, 2024);
        Date nextYear = new Date(30, 3, 2025);
        Date nextMonth = new Date(30, 4, 2024);

        //instantiating my tasks
        Task task1 = new Task("This is my first task", thisWeekend, Priority.HIGH);
        Task task2 = new Task("This is my second task", nextMonth, Priority.MEDIUM);
        Task task3 = new Task("This is my third task", nextYear, Priority.LOW);

        // this is where the linked list is being made
        Listuse<Task> taskList = new NotEmptyList<>(task1, new EmptyList<>());


        // just want to get my tasks on my linked list
        taskList = taskList.addFront(task2);
        taskList = taskList.addFront(task3);

        //Demonstrating Objective 1: abstract map and abstract filter
        Listuse<String> listofStrings = taskList.map(new TaskToString());
        listofStrings.forEach(new PrintStringConsumer());

        // will filter all my tasks to only had the HIGH priority tasks
        Listuse<Task> highPriorityTasks = taskList.filter(task -> task.getPriority() == Priority.HIGH);
        // I could just print using my PrintTaskConsumer but I am again showing map works
        System.out.println();
        System.out.println("Demonstrating my filter method to show ONLY HIGH priority tasks!");
        Listuse<String> listofHighPriority = highPriorityTasks.map(new TaskToString());
        listofHighPriority.forEach(new PrintStringConsumer());
        System.out.println();

        // Demonstrating Objective 2: fold with an abstract count method - can take in any datatype of linked list
        int countTasks = taskList.fold(0,(x, data) -> x + 1);
        System.out.println("Task count: " + countTasks);
        System.out.println();

        // Demonstrating Objective 3: Ability to determine equality between tasks
                // need to make some equivalent tasks
        Task equalTask1 = new Task("study", thisWeekend, Priority.HIGH);
        Task equalTask2 = new Task("study", thisWeekend, Priority.HIGH);
        //List<Task> equalList = new NotEmptyList<>(equalTask1, new EmptyList<>());
        //equalList.addFront(equalTask2); // great, now we have a linked list with 2 equivalent tasks

        //PrintTaskConsumer printTask = new PrintTaskConsumer();
        //equalList.forEach(printTask);
        System.out.println("Checking if the tasks are equal: " + equalTask1.equals(equalTask2)); // should be true
        System.out.println("Checking if the tasks are equal: " + equalTask1.equals(task1)); // should be false

        System.out.println();

        //Objective 4 compare tasks based on priority
            // again setting up my tasks
        Task middle = new Task("Should be in the middle", nextMonth, Priority.MEDIUM);
        Task first = new Task("Should be first", thisWeekend, Priority.HIGH);
        Task last = new Task("Should be last", nextYear, Priority.LOW);
        Listuse<Task> sortedTasks = new NotEmptyList<>(middle, new EmptyList<>());
        sortedTasks = sortedTasks.addFront(first);
        sortedTasks = sortedTasks.addFront(last);

        System.out.println("Just to see the current order of tasks in the list");
        sortedTasks.forEach(new PrintTaskConsumer()); // they are out of order

        //Extention adding priority que
        PriorityQueue<Task> taskQue = new PriorityQueue<>(Task.PRIORITY_COMPARATOR);
        taskQue.add(middle);
        taskQue.add(first);
        taskQue.add(last);

        while (!taskQue.isEmpty())
        {
            Task task = taskQue.poll(); // will retrieve and remove head based on prioritya
            System.out.println(task.getDescription() + " - " + task.getPriority());
        }

        // for the real objective- comparing two different tasks
            // result < 0 means "first" (first parameter too) will have a higher priority; which in this case we know it does
            // result > 0 means "first" will have a lower priority; which we know it will not
            // result = 0 means "first" will have the same priority; which we know it doesnt
        int result = Task.PRIORITY_COMPARATOR.compare(first, last);
        if(result < 0){System.out.println("fist task has higher priority than the last");}
        else if(result > 0){System.out.println("last task has higher priority than the first");}
        else{System.out.println("fist task has equal priority than the last");}

        System.out.println();

        // for good fasion lets just show another example using a tasks made during the beggining of this code
        int result2 = Task.PRIORITY_COMPARATOR.compare(task1, first);
        if(result2 < 0){System.out.println("task1 has higher priority than first");}
        else if(result2 > 0){System.out.println("task 1 has lower priority than first");}
        else{System.out.println("The tasks had equal priority");}

        System.out.println();


        //Objective 5 reading and writing to a csv file
            //used to demonstrate reading
        String inputFile = "taskList.csv";
            //used to demonstrate writing to csv
        String outPutFile = "new_taskList.csv";


        try
        {
            //load up the csv
            java.util.List<Task> taskin = CsvTaskUtil.loadTasksFromCSV(inputFile); // holy crap i was having issues with this the whole lab 5... since i named my List interface this
            System.out.println("Tasks successfully loaded from CSV");

            // lets prove that and display the contents!
            taskin.forEach(new PrintTaskConsumer());


            System.out.println();

            // now lets see if we can add to our csv
            Task newTask = new Task("Please work", thisWeekend, Priority.HIGH);
            taskin.add(newTask);
            CsvTaskUtil.saveToCSV(taskin,outPutFile);
            System.out.println("Tasks added to CSV successfuly~!");

            // and to prove it saved to the csv

            System.out.println();
            taskin.forEach(new PrintTaskConsumer());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */


        CryptographyWork caesarsCipher = new CaesarsCipher();
        String message = "Hello";
        String message2 = "zzz";


        String encrypted = caesarsCipher.encrypt(message2);
        System.out.println("hello becomes:  " + encrypted);
    }
}
