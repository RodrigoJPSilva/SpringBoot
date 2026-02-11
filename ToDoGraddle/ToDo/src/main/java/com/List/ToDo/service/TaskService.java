package com.List.ToDo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.List.ToDo.dto.TaskDTO;
import com.List.ToDo.entities.Task;
import com.List.ToDo.repository.TaskRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @NotNull
    public TaskDTO criarTask(TaskDTO dto) {
        Task task = new Task(dto);
        return dto;
    }

    public Optional<Task> showTaskById(long id) {

        return taskRepository.findById(id);
    }

    public List<Task> showAllTasks(@Valid TaskDTO taskDTO){
        List<Task> tasks = taskRepository.findAll();
        List<Task> listTasks = new ArrayList<>();
        listTasks = tasks;
        
        return listTasks;
    }

    public String updateTask(long id, TaskDTO dto) {
        Optional<Task> taskList = taskRepository.findById(id);

        if (taskList.isPresent()) {
            Task task = taskList.get();
            task.setNome(dto.getNome());
            task.setDescricao(dto.getDescricao());
            task.setStatus(dto.getStatus());
            task.setDtInicio(dto.getDtInicio());
            task.setDtFinal(dto.getDtFinal());

            return task.toString();
        } else {
            return "Tarefa não encontrada";
        }

    }
    public String deleteTaskById(long id) {
        if (taskRepository.findById(id) != null) {
            taskRepository.deleteById(id);
            return "Tarefa deletada com sucesso";
        }  else {
            return "Tarefa não encontrada";
        }
    }

}