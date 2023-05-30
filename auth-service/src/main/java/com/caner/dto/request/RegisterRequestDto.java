package com.caner.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDto {
    @NotBlank(message = "Please enter a username.")
    @Column(unique = true)
    @Size(min = 3, max = 15, message = "Username must be min 3 max 15 character.")
    private String username;
    @Email(message = "Please write a valid email.")
    @Column(unique = true)
    private String email;
    @NotBlank
    @Size(min = 5, max = 16, message = "Password must be min 5 max 16 characters.")
    private String password;
    private String repassword;
}
