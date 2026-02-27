package com.List.ToDo.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskDTO {

    @NotNull
    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    private String status;
    private LocalDate dtInicio;
    private LocalDate dtFinal;

    public TaskDTO() {
    }

    public TaskDTO(long id, String nome, String descricao, String status, LocalDate dtInicio, LocalDate dtFinal) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dtInicio = dtInicio;
        this.dtFinal = dtFinal;
    }
}
