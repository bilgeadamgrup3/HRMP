package com.bilgeadam.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterRequestDto {
    @NotBlank(message = "Kullanıcı adı boş geçilemez.")
    @Size(min = 3, max = 32)
    /**
     * BüyükHarf olmamalı, küçük harf olmalı, rakam içerebilir . nokta olabilir
     * diğer tüm özel karakterler olamaz.
     */
    String username;
    @NotBlank(message = "Şifre boş geçilmez.")
    @Size(min = 3, max = 32)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$")
    String password;
    @NotBlank(message = "Şifre boş geçilmez.")
    @Size(min = 8, max = 64)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$")
    String repassword;
    @Email(message = "Lütfen geçerli bir e-mail adresi giriniz.")
    String email;
}
