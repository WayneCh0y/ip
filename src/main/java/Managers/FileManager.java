package Managers;

import TaskItems.Deadline;
import TaskItems.Event;
import TaskItems.Task;
import TaskItems.Todo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private static String filePath;

    private static final String SPLIT_REGEX = "\\|";

    private static final String DEADLINE_TASK = "[D]";
    private static final String TODO_TASK = "[T]";
    private static final String EVENT_TASK = "[E]";

    private static final int TASK_TYPE_INDEX = 0;
    private static final int TODO_IS_DONE_INDEX = 2;
    private static final int DEADLINE_IS_DONE_INDEX = 3;
    private static final int EVENT_IS_DONE_INDEX = 4;

    private static final int TASK_DESCRIPTION = 1;
    private static final int DEADLINE_BY_INDEX = 2;
    private static final int EVENT_FROM_INDEX = 2;
    private static final int EVENT_TO_INDEX = 3;

    private static final String DIRECTORY_NAME = "data";

    public FileManager(String path) {
        this.filePath = path;
    }

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
            String[] specifiers = details.split(SPLIT_REGEX);
            String taskType = specifiers[TASK_TYPE_INDEX];

            switch (taskType) {
            case DEADLINE_TASK:
                Deadline deadline = new Deadline(specifiers[TASK_DESCRIPTION], specifiers[DEADLINE_BY_INDEX]);
                if (specifiers[DEADLINE_IS_DONE_INDEX].equals("true")) {
                    deadline.markAsDone();
                }
                TaskManager.addTask(deadline);
                break;
            case TODO_TASK:
                Todo todo = new Todo(specifiers[TASK_DESCRIPTION]);
                if (specifiers[TODO_IS_DONE_INDEX].equals("true")) {
                    todo.markAsDone();
                }
                TaskManager.addTask(todo);
                break;
            case EVENT_TASK:
                Event event = new Event(specifiers[TASK_DESCRIPTION], specifiers[EVENT_FROM_INDEX], specifiers[EVENT_TO_INDEX]);
                if (specifiers[EVENT_IS_DONE_INDEX].equals("true")) {
                    event.markAsDone();
                }
                TaskManager.addTask(event);
                break;
            default:
                System.out.println("Unknown task type: " + taskType);
                break;
            }
        }

        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }

        return taskManager;
    }

    public static void save(List<Task> taskList) throws IOException {
        File directory = new File(DIRECTORY_NAME);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) { // Overwrites file
            for (Task task : taskList) {
                writer.write(toSaveAsString(task));
                writer.newLine();
            }
        }
    }
}
