package com.List.ToDo.service;

import com.List.ToDo.entities.Task;
import com.List.ToDo.entities.User;
import com.List.ToDo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task createTaskForUser(Long userId, Task task) {
        User user = userService.findById(userId);
        task.setUser(user);
        return taskRepository.save(task);
    }

    public List<Task> listTasksByUser(Long userId) {
        userService.findById(userId);
        return taskRepository.findByUserId(userId);
    }

    public Task updateTask(Long taskId, Task updatedData) {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask.setTitle(updatedData.getTitle());
        existingTask.setDescription(updatedData.getDescription());
        existingTask.setCompleted(updatedData.isCompleted());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}