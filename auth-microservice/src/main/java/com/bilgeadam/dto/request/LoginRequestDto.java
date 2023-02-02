package com.bilgeadam.dto.request;

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
public class LoginRequestDto {

    @Email(message = "Lutfen gecerli bir e-mail adresi giriniz.")
    @NotBlank(message = "Kullanici e-maili bos gecilemez.")
    String email;

    @NotBlank(message = "Şifre boş geçilemez")
    @Size(min = 8,max = 16)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$", message = "Sifreniz istenilen özelliklere sahip degil.")
    String password;

}