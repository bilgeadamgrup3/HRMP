package com.bilgeadam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DetailResponseDto {
    private String name;
    private String middleName;
    private String lastName;
    private String lastName2;
    private String profileImage;
    private String identificationNumber;
    private String birthplace;
    private String birthDate;
    private String job;
    private String department;
    private String email;
    private String address;
    private String telephone;
}
