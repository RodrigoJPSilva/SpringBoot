package com.List.ToDo.controller;

import com.List.ToDo.dto.UserDTO;
import com.List.ToDo.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("usuario")
public class UserController {

    private final UserService usuarioService;

    public UserController(UserService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "cadastro")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUser(userDTO));
    }


}
