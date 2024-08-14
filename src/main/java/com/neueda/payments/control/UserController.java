package com.neueda.payments.control;

import com.neueda.payments.model.User;
import com.neueda.payments.model.dto.UserDTO;
import com.neueda.payments.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<UserDTO> getUsers() {
        return userService.findAll().stream().map(UserDTO::new).toList();
    }

    @GetMapping("/user/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return new UserDTO(userService.findById(id));
    }

    @PostMapping("/user")
    public UserDTO save(@RequestBody User user) {
        return new UserDTO(userService.save(user));
    }
}
