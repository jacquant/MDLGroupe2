package be.unamur.mdl_groupe2.root.controller;

import be.unamur.mdl_groupe2.root.model.User;
import be.unamur.mdl_groupe2.root.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/me")
    public ResponseEntity currentUser(@AuthenticationPrincipal UserDetails userDetails) {
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userDetails.getUsername());
        model.put("roles", userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(toList())
        );
        return ok(model);
    }

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
        user.setFirstName(userObject.getFirstName());
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