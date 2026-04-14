package com.List.ToDo.controller;

import com.List.ToDo.dto.UserDTORequest;
import com.List.ToDo.dto.UserDTOResponse;
import com.List.ToDo.entities.User;
import com.List.ToDo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTOResponse> createUser(@Valid @RequestBody UserDTORequest dto) {
        User user = dto.toEntity();
        User newUser = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTOResponse(newUser));
    }

    @GetMapping
    public ResponseEntity<List<UserDTOResponse>> listAllUsers() {
        List<User> users = userService.listAll();

        List<UserDTOResponse> responseList = users.stream()
                .map(UserDTOResponse::new)
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTOResponse> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(new UserDTOResponse(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
