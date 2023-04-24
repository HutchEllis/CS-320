package TaskService;
public class Task {
	private String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
    	if (taskId == null || taskId.length()>10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        
        if (name == null || name.length()>20) {
            throw new IllegalArgumentException("Invalid Task Name");
        }
        
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
