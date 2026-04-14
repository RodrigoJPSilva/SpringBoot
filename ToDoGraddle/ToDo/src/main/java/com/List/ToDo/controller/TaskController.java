package com.List.ToDo.controller;

import com.List.ToDo.dto.TaskDTORequest;
import com.List.ToDo.dto.TaskDTOResponse;
import com.List.ToDo.entities.Task;
import com.List.ToDo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTOResponse> updateTask(@PathVariable Long id, @RequestBody TaskDTORequest dto) {
        Task updatedTask = taskService.updateTask(id, dto.toEntity());
        return ResponseEntity.ok(new TaskDTOResponse(updatedTask));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
