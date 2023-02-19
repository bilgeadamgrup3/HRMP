package com.bilgeadam.controller;

import com.bilgeadam.dto.request.CreateCompanyRequestDto;
import com.bilgeadam.dto.response.CompanyGetAllResponseDto;
import com.bilgeadam.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bilgeadam.constants.RestApi.*;


@RestController
@RequestMapping(COMPANY)
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping(CREATECOMPANY)
    public ResponseEntity<String> CreateCompany(@RequestBody CreateCompanyRequestDto dto) {

        companyService.createCompany(dto);
        return ResponseEntity.ok("başarıyla kaydedildi");
    }
    @GetMapping(COMPANYGETALL)
    public ResponseEntity<List<CompanyGetAllResponseDto>> getAllCorporations(){
        return ResponseEntity.ok(companyService.companyGetAll());
    }
}
