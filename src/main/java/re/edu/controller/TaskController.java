package re.edu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.model.Task;
import re.edu.model.User;
import re.edu.service.TaskService;
import re.edu.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private TaskService taskService;
    private UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTasks(){
        List<Task> taskList = taskService.findAllTask();
        if(taskList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Task task){
        User user = userService.findUserById(task.getAssignedTo());
        if(user == null){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
}
