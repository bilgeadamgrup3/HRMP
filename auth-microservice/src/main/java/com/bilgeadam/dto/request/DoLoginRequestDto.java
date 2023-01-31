package com.bilgeadam.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DoLoginRequestDto {
    @NotBlank(message = "Kullanıcı adı boş geçilemez.")
    @Size(min = 3, max = 32)
    String username;
    @NotBlank
    @Size(min = 8, max = 64)
    String password;
}
