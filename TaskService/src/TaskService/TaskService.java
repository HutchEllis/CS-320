package TaskService;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID doesn't exist");
        }
        tasks.remove(taskId);
    }

    public void updateTaskName(String taskId, String name) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID doesn't exist");
        }
        Task task = tasks.get(taskId);
        task.setName(name);
        tasks.put(taskId, task);
    }

    public void updateTaskDescription(String taskId, String description) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID doesn't exist");
        }
        Task task = tasks.get(taskId);
        task.setDescription(description);
        tasks.put(taskId, task);
    }
    
    public Map<String, Task> getTasks() {
        return tasks;
    }
}
