package com.List.ToDo.dto;

import com.List.ToDo.entities.Status;
import com.List.ToDo.entities.Task;
import com.List.ToDo.entities.User;
import com.List.ToDo.repository.TaskRepository;
import com.List.ToDo.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;


@Getter
@Setter
public class TaskResponseDTO {

    @Autowired
    private TaskRepository tarefaRepository;
    private long id;
    private String nome;
    private String descricao;
    private String status;
    private LocalDate dtInicio;
    private LocalDate dtFinal;

    public TaskResponseDTO(long id, String nome, String descricao, String status, LocalDate dtInicio, LocalDate dtFinal) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dtInicio = dtInicio;
        this.dtFinal = dtFinal;
    }
    
    public TaskResponseDTO saveTask(@Valid TaskRequestDTO req) {
        Task task = new Task();
        task.setNome(req.getNome());
        task.setDescricao(req.GetDescricao();;
        task.setDtInicio(LocalDate.now());
        task.setStatus(Status.PENDING);
        User user = UserRepository.getReferenceById(req.getIdUser());
    }
}
