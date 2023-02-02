package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @Column(name= "email" ,unique = true)
    @NotBlank
    private String email;
    private String password;
    private String activationCode;
    private String token;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    Roles role = Roles.EMPLOYEE;

}