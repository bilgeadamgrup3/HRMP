package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateCompanyRequestDto {
    String name;
    String title;
    String mersisNo;
    String taxNo;
    String taxOffice;
    String logo;
    String phone;
    String address;
    String email;
    int numberOfEmployees;
    String foundationYear;
    Date contractStartDate;
    Date contractEndDate;
}
