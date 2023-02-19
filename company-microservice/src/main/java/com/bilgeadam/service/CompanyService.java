package com.bilgeadam.service;

import com.bilgeadam.dto.request.CreateCompanyRequestDto;
import com.bilgeadam.dto.response.CompanyGetAllResponseDto;

import com.bilgeadam.exception.CompanyMicroserviceException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.mapper.ICompanyMapper;
import com.bilgeadam.repository.ICompanyRepository;
import com.bilgeadam.repository.entity.Company;
import com.bilgeadam.utility.ServiceManager;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CompanyService extends ServiceManager<Company,Long> {
    private final ICompanyRepository repository;

    public CompanyService(ICompanyRepository repository) {
        super(repository);
        this.repository = repository;
    }
public Company createCompany(CreateCompanyRequestDto dto){

    try {
        Company company= ICompanyMapper.INSTANCE.toCompany(dto);
        company.setContractStartDate(System.currentTimeMillis());
        return company;
    } catch (Exception e) {

        e.printStackTrace();
        throw new CompanyMicroserviceException(ErrorType.COMPANY_NOT_CREATED);
    }
}
    public List<CompanyGetAllResponseDto> companyGetAll() {
        return ICompanyMapper.INSTANCE.toCompanyGetAllResponseDtos(repository.findAll());
    }


}
