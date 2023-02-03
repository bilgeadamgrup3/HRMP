package com.bilgeadam.dto.request;

import com.bilgeadam.repository.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDto {

    @Email(message = "Lutfen gecerli bir e-mail adresi giriniz.")
    @NotBlank(message = "Kullanici e-maili bos gecilemez.")
    String email;

    @NotBlank(message = "Sifre bos gecilemez.")
    @Size(min = 8 ,max=32 ,message = "Sifre en az 8 karakter en fazla 32 karakter olabilir")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$")
    String password;

    @NotBlank(message = "Sifre bos gecilemez.")
    @Size(min = 8,max = 32)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$")
    String rePassword;

    Roles role;
}