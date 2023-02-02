package com.bilgeadam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SummaryResponseDto {
    private String profileImage;
    private String name;
    private String middleName;
    private String lastName;
    private String email;
    private String address;
    private String telephone;
    private String job;
    private String department;
}
