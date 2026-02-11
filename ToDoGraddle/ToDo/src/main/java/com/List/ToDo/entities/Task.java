package com.List.ToDo.entities;

import com.List.ToDo.dto.TaskDTO;
import jakarta.persistence.*;
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
@Entity(name = "tarefa")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String descricao;
    private String status;
    private LocalDate dtInicio;
    private LocalDate dtFinal;


    public Task(long id, String nome, String descricao, String status, LocalDate dtInicio, LocalDate dtFinal) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dtInicio = dtInicio;
        this.dtFinal = dtFinal;
    }
    
    public Task(TaskDTO dto) {
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.status = dto.getStatus();
        this.dtInicio = dto.getDtInicio();
        this.dtFinal = dto.getDtFinal();
    }
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "A tarefa precisa de um usuário")
    private User usuario;
}

