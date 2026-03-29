package re.edu.repository;

import org.springframework.stereotype.Repository;
import re.edu.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "vanh123", "vanh@gmail.com", "ADMIN"));
        users.add(new User(2, "linh456", "linh@gmail.com", "USER"));
        users.add(new User(3, "teo789", "teo@gmail.com", "USER"));
    }

    public List<User> findAll(){
        return users;
    }

    public User findById(int id){
        return users.stream().filter(x -> x.getId()== id).findFirst().orElse(null);
    }
}
