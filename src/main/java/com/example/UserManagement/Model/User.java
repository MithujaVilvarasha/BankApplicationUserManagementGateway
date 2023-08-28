package com.example.UserManagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    @Column(name="username")
    @NotNull(message = "username should not be null")
    @NotBlank(message = "username should not be blank")
    @Size(max = 10, message = "Username can't be more than 20 characters")
    @Pattern(regexp = "[a-z]+$",message = "username should be match the pattern")
    private String username;


    @Column(name = "password")
    @NotNull(message = "password should not be null")
    @NotBlank(message = "password should not be blank")
    private String password;


}
