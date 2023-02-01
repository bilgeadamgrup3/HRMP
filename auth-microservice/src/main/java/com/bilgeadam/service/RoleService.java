package com.bilgeadam.service;

import com.bilgeadam.repository.IRoleRepository;
import com.bilgeadam.repository.entity.Role;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends ServiceManager<Role,Long> {
    private final IRoleRepository repository;
    public RoleService(IRoleRepository repository) {
        super(repository);
        this.repository=repository;
    }

    public List<Role> findByAuthid(Long id){
        return repository.findByAuthid(id);
    }
}
