package com.bilgeadam.utility;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceManager<T extends BaseEntity,ID> implements IService<T,ID> {

    private final JpaRepository<T,ID> repository;

    public ServiceManager(JpaRepository<T, ID> repository) {

        this.repository = repository;
    }


    @Override
    public T save(T t) {
        t.setCreateDate(System.currentTimeMillis());
        t.setUpdateDate(System.currentTimeMillis());
        t.setActive(true);
        return repository.save(t);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> t) {
        t.forEach(p -> {
            p.setActive(true);
            p.setCreateDate(System.currentTimeMillis());
            p.setUpdateDate(System.currentTimeMillis());
        });
        return repository.saveAll(t);
    }

    @Override
    public T update(T t) {
        t.setUpdateDate(System.currentTimeMillis());
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        t.setActive(false);
        repository.save(t);
    }

    @Override
    public void deleteById(ID id) {
        Optional<T> t= repository.findById(id);
        if (t.isPresent())
            t.get().setActive(false);
        repository.save(t.get());
    }

    @Override
    public List<T> findAll() {

        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {

        return repository.findById(id);
    }
}
