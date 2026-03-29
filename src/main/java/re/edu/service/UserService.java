package re.edu.service;

import org.springframework.stereotype.Service;
import re.edu.model.User;
import re.edu.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(int id){
        return userRepository.findById(id);
    }
}
