package TaskService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
	@Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("0123456789", "Task One", "This is the first task");
        taskService.addTask(task);
        assertEquals(1, taskService.getTasks().size());
        assertEquals(task, taskService.getTasks().get("0123456789"));
    }

    @Test
    public void testAddTaskDuplicateId() {
        TaskService taskService = new TaskService();
        Task task1 = new Task("0123456789", "Task One", "This is the first task");
        Task task2 = new Task("0123456789", "Task Two", "This is the second task");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("0123456789", "Task One", "This is the first task");
        taskService.addTask(task);
        taskService.deleteTask("0123456789");
        assertEquals(0, taskService.getTasks().size());
    }

    @Test
    public void testDeleteTaskNonexistentId() {
        TaskService taskService = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("0123456789");
        });
    }

    @Test
    public void testUpdateTaskName() {
        TaskService taskService = new TaskService();
        Task task = new Task("0123456789", "Task One", "This is the first task");
        taskService.addTask(task);
        taskService.updateTaskName("0123456789", "New Task One");
        assertEquals("New Task One", taskService.getTasks().get("0123456789").getName());
    }

    @Test
    public void testUpdateTaskNameNonexistentId() {
        TaskService taskService = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("0123456789", "New Task One");
        });
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService taskService = new TaskService();
        Task task = new Task("0123456789", "Task One", "This is the first task");
        taskService.addTask(task);
        taskService.updateTaskDescription("0123456789", "This is the updated Task One");
        assertEquals("This is the updated Task One", taskService.getTasks().get("0123456789").getDescription());
    }

    @Test
    public void testUpdateTaskDescriptionNonexistentId() {
        TaskService taskService = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("0123456789", "This is the updated Task One");
        });
    }
}
