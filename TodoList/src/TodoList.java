import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class TodoList {

    // create a list to store task
    private static List<String> tasks = new ArrayList<>();
    private static final String File_name = "todos.txt";

    // list of the menu items
    public static void showMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. View All Tasks");
        System.out.println("4. Save tasks to file");
        System.out.println("5. Close the program");
        System.out.print("Choose an option: ");
    }

    // method to add something to tasks
    public static void addTask(Scanner scanner) {
        System.out.print("Enter Task: ");
        String task = scanner.nextLine();
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

    // view your todo tasks
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

    // save task to file
    public static void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(File_name))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
            System.out.println("Tasks saved succesfully");

        } catch (IOException e) {
            System.out.println("Error saving tasks");
        }

    }

    // load tasks saved on the file
    public static void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(File_name))) {
            String task;
            while ((task = reader.readLine()) != null) {
                tasks.add(task);
            }
            System.out.println("Tasks loaded successfully");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        catch (IOException e) {
            System.out.println("Failed to retrieve tasks");
        }
    }

    // close the program
    public static void closeProgram() {
        System.out.println("Exiting the program....");
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        loadTasks();
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
                case 4:
                    saveTasks();
                case 5:
                    running = false;
                    closeProgram();
                default:
                    break;
            }
        }
    }
}

// Todo: => Add a make completed function for the completed tasks
