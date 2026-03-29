package re.edu.repository;

import org.springframework.stereotype.Repository;
import re.edu.model.Task;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    public TaskRepository() {
        for (int i = 1; i <= 10; i++) {
            String priority = (i % 2 == 0) ? "high" : "low";
            int userId = (i % 2 == 0) ? 1 : 2;
            tasks.add(new Task(i, "Task " + i, "Làm bài tập số " + i, priority, userId));
        }
    }

    public List<Task> findAll(){
        return tasks;
    }

    public void save(Task task){
        tasks.add(task);
    }
}
