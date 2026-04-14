package com.List.ToDo.dto;

import com.List.ToDo.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTORequest {
    @NotBlank(message = "Nome inválido")
    private String name;
    @NotBlank(message = "Email inválido") @Email
    private String email;
    @NotBlank(message = "Senha inválida")
    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres ")
    private String password;

    public User toEntity() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }

}

