package be.unamur.mdl_groupe2.root.controller;

import be.unamur.mdl_groupe2.root.model.User;
import be.unamur.mdl_groupe2.root.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @PutMapping("/users/{user_id}")
    public User update(@PathVariable("user_id") Long userId, @RequestBody User userObject) {
        User user = userRepository.getOne(userId);
        user.setFirstname(userObject.getFirstname());
        user.setSurname(userObject.getSurname());
        user.setEmail(userObject.getEmail());
        user.setOrganization(userObject.getOrganization());
        user.setHonorific(userObject.getHonorific());
        user.setEmailContact(userObject.getEmailContact());
        return userRepository.save(user);
    }


    @DeleteMapping("/users/{user_id}")
    public List<User> delete(@PathVariable("user_id") Long userId) {
        userRepository.deleteById(userId);
        return userRepository.findAll();
    }


    @GetMapping("/users/{user_id}")
    public User findByUserId(@PathVariable("user_id") Long userId) {
        return userRepository.getOne(userId);
    }
}