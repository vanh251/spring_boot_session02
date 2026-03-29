package re.edu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.edu.model.User;
import re.edu.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> userList = userService.findAllUsers();
        if(userList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
