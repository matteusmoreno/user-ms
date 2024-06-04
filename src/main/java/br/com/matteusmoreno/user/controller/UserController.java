package br.com.matteusmoreno.user.controller;

import br.com.matteusmoreno.user.model.User;
import br.com.matteusmoreno.user.request.CreateUserRequest;
import br.com.matteusmoreno.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid CreateUserRequest request) {

        User user = userService.createuser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
