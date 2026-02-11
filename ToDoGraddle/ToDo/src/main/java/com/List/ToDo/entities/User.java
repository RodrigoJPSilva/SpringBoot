package com.List.ToDo.entities;

import com.List.ToDo.dto.TaskDTO;
import com.List.ToDo.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;

    public User (UserDTO dto) {
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.senha = dto.getSenha();
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore // Evita loop infinito na serialização se buscar tarefas diretamente
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTask() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
    }
}
