package main;

import main.model.Task;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    private static int currentId = 1;
    private static ConcurrentHashMap<Integer, Task> tasks = new ConcurrentHashMap<>();

    public static List<Task> getAllTasks() {
        ArrayList<Task> tasksList = new ArrayList<>(tasks.values());
        return tasksList;
    }

    public static int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        task.setDate(new Date().toString());
        tasks.put(id, task);
        return id;
    }

    public static Task deleteTask(int id) {
        return tasks.remove(id);
    }

    public static void deleteAllTasks() {
        tasks.clear();
        currentId = 1;
    }

    public static Task getTask(int id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id);
        }
        return null;
    }

    public static Task editTask(int id, String text, String date) {
        if (!tasks.containsKey(id)) {
            return null;
        }
        Task task = tasks.get(id);
        if (!(text == null)) {
            task.setText(text);
        }
        if (!(date == null)) {
            task.setDate(date);
        }
        tasks.replace(id, task);
        return tasks.get(id);
    }
}
