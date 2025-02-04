package com.example.testTask.services.impl;

import com.example.testTask.models.Computer;
import com.example.testTask.models.Model;
import com.example.testTask.repositories.ComputerRepository;
import com.example.testTask.services.ComputerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService implements ComputerServiceInterface {

    @Autowired
    private ComputerRepository repository;

    @Override
    public List<Computer> getAllComputers(Specification<Computer> spec)
    {
        return repository.findAll(spec);
    }

    @Override
    public  Computer create(Computer computer)
    {
        return repository.save(computer);
    }

}
