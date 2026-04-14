package com.List.ToDo.controller;

import com.List.ToDo.dto.TaskDTORequest;
import com.List.ToDo.dto.TaskDTOResponse;
import com.List.ToDo.entities.Task;
import com.List.ToDo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/users")
public class UserTaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/{id}/tasks")
    public ResponseEntity<TaskDTOResponse> createTask( @PathVariable Long id, @RequestBody TaskDTORequest dto) {
        Task task = dto.toEntity();

        Task newTask = taskService.createTaskForUser(id, task);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TaskDTOResponse(newTask));
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskDTOResponse>> listUserTasks(@PathVariable Long id) {
        List<Task> tasks = taskService.listTasksByUser(id);

        List<TaskDTOResponse> responseList = tasks.stream()
                .map(TaskDTOResponse::new)
                .toList();

        return ResponseEntity.ok(responseList);
    }
}