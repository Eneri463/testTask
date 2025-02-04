package com.example.testTask.services.impl;

import com.example.testTask.models.Television;
import com.example.testTask.repositories.TelevisionRepository;
import com.example.testTask.services.TelevisionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService implements TelevisionServiceInterface {

    @Autowired
    private TelevisionRepository repository;

    @Override
    public List<Television> getAllTelevisions(Specification<Television> spec)
    {
        return repository.findAll(spec);
    }

    @Override
    public Television create(Television television)
    {
        return repository.save(television);
    }
}
