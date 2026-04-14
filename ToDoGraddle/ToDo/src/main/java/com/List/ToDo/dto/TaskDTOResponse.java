package com.List.ToDo.dto;


import com.List.ToDo.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTOResponse {

    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private Long userId;

    // Constructor that takes an Entity and transforms it into a DTO

        // Constructor that takes an Entity and transforms it into a DTO
        public TaskDTOResponse(Task task) {
            this.id = task.getId();
            this.title = task.getTitle();
            this.description = task.getDescription();
            this.completed = task.isCompleted();
            this.userId = task.getUser().getId();
        }
}