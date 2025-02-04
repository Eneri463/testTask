package com.example.testTask.services;

import com.example.testTask.models.Computer;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ComputerServiceInterface {

    public List<Computer> getAllComputers(Specification<Computer> spec);

    public Computer create(Computer computer);
}
