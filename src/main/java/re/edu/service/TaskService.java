package re.edu.service;

import org.springframework.stereotype.Service;
import re.edu.model.Task;
import re.edu.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTask(){
        return taskRepository.findAll();
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }
}
