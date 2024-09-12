import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {

    // create a list to store task
    private static List<String> tasks = new ArrayList<>();

    // list of the menu items
    public static void showMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. View All Tasks");
        System.out.println("4. Mark Task as Completed");
        System.out.println("5. Save and Exit");
        System.out.print("Choose an option: ");
    }

    // method to add something to tasks
    public static void addTask(Scanner scanner) {
        System.out.print("Enter Task: ");
        String task = scanner.next();
        tasks.add(task);
        System.out.println("Task added to the list");
    }

    public static void removeTask(Scanner scanner) {
        // view the tasks that are available
        viewTask();
        if (tasks.isEmpty()) {
            return;
        }
        // enter the index of the task to be removed from the list
        System.out.print("Enter the the of the task to remove: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        if (taskNumber < 0 || taskNumber >= tasks.size()) {
            System.out.println("Invalid task number");
        } else {
            tasks.remove(taskNumber);
            System.out.println("Task removed from the list");
        }

    }

    public static void viewTask() {
        if (tasks.isEmpty()) {
            System.out.println("Task list is empty");
        } else {
            System.out.println("Your Tasks: ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(tasks.get(i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        // loadTasks();
        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    viewTask();
                    break;
                default:
                    break;
            }
        }
    }
}
