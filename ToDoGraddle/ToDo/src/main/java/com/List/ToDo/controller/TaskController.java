package com.List.ToDo.controller;

import com.List.ToDo.dto.TaskDTO;
import com.List.ToDo.entities.Task;
import com.List.ToDo.service.TaskService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("tarefas")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "nova")
    public ResponseEntity<?> saveTask(@Valid @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.criarTask(taskDTO));
    }
    @GetMapping(value = "listar")
    public ResponseEntity<?>  taskList(@Valid @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.status(HttpStatus.FOUND).body(taskService.showAllTasks(taskDTO));
    }

    @GetMapping(value = "/listar/{id}")
    public ResponseEntity<?>  taskById(@Valid @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.status(HttpStatus.FOUND).body(taskService.showTaskById(taskDTO.getId()));
    }
    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<?>  delById(@Valid @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.status(HttpStatus.GONE).body(taskService.deleteTaskById(taskDTO.getId()));
    }
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?>  updateTask(@Valid @RequestBody TaskDTO taskDTO, @RequestBody TaskDTO novaTask) {
        if (taskService != null) {
            return ResponseEntity.ok(taskService.updateTask(taskDTO.getId(), novaTask));
        } else {
            return ResponseEntity.notFound().build();
        }
}
