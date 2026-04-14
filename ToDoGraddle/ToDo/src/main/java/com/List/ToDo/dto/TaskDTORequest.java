package com.List.ToDo.dto;
import com.List.ToDo.entities.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTORequest {

    @NotBlank
    private String title;
    @NotBlank
    private String description;

    private boolean completed;

    public Task toEntity() {
        Task task = new Task();
        task.setTitle(this.title);
        task.setDescription(this.description); // You missed this line!
        task.setCompleted(this.completed);
        return task;
    }

}
