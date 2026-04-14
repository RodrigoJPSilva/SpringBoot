package com.List.ToDo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tarefa")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String status;
    private boolean completed;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // nullable pra não existir tarefa sem usuário
    private User user;

}

