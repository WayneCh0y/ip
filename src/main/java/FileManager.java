import Managers.TaskManager;
import TaskItems.Deadline;
import TaskItems.Event;
import TaskItems.Task;
import TaskItems.Todo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private static String filePath = "data/Gojo.txt";

    public static String toSaveAsString(Task task) {
        return task.getTaskType() + "|" + task.getSaveDescription() + "|" + task.getStatus();
    }

    public static TaskManager load() throws IOException {
        File f = new File(filePath);
        if (!f.exists()) {
            return new TaskManager();
        }
        Scanner s = new Scanner(f);
        TaskManager taskManager = new TaskManager();

        while (s.hasNext()) {
            String details = s.nextLine();
            String[] specifiers = details.split("\\|");
            String taskType = specifiers[0];
            switch (taskType) {
            case "[D]":
                Deadline deadline = new Deadline(specifiers[1], specifiers[2]);
                if (specifiers[3].equals("true")) {
                    deadline.markAsDone();
                }
                TaskManager.addTask(deadline);
                break;
            case "[T]":
                Todo todo = new Todo(specifiers[1]);
                if (specifiers[2].equals("true")) {
                    todo.markAsDone();
                }
                TaskManager.addTask(todo);
                break;
            case "[E]":
                Event event = new Event(specifiers[1], specifiers[2], specifiers[3]);
                if (specifiers[4].equals("true")) {
                    event.markAsDone();
                }
                TaskManager.addTask(event);
                break;
            default:
                System.out.println("Unknown task type: " + taskType);
                break;
            }
        }

        File file = new File("data/Gojo.txt");
        if (file.exists()) {
            file.delete();
        }

        return taskManager;
    }

    public static void save(List<Task> taskList) throws IOException {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        FileWriter fileWriter = new FileWriter(filePath, true);
        for (Task tasks : taskList) {
            fileWriter.write(toSaveAsString(tasks) + "\n");
        }
        fileWriter.close();
    }
}
