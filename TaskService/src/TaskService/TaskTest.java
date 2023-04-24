package TaskService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
	@Test
	public void testTaskCreation() {
        String taskId = "0123456789";
        String name = "Task One";
        String description = "Default Description";
		Task task = new Task(taskId, name, description);
        assertEquals(taskId, task.getTaskId());
        assertEquals(name, task.getName());
        assertEquals(description, task.getDescription());
	}
	
	@Test
	 public void testTaskNameUpdate() {
	        String taskId = "0123456789";
	        String name = "Task One";
	        String description = "Default Description1";
	        Task task = new Task(taskId, name, description);
	        String updatedName = "Task Two";
	        task.setName(updatedName);
	        assertEquals(updatedName, task.getName());
	}        
	 
	@Test
	 public void testTaskDescriptionUpdate() {
	        String taskId = "0123456789";
	        String name = "Task One";
	        String description = "Default Description";
	        Task task = new Task(taskId, name, description);
	        String updatedDescription = "Updated Description";
	        task.setDescription(updatedDescription);
	        assertEquals(updatedDescription, task.getDescription());
	}
}
