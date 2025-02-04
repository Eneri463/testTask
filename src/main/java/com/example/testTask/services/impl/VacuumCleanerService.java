package com.example.testTask.services.impl;

import com.example.testTask.models.VacuumCleaner;
import com.example.testTask.repositories.VacuumCleanerRepository;
import com.example.testTask.services.VacuumCleanerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacuumCleanerService implements VacuumCleanerServiceInterface {

    @Autowired
    private VacuumCleanerRepository repository;

    @Override
    public List<VacuumCleaner> getAllVacuumCleaners(Specification<VacuumCleaner> spec)
    {
        return repository.findAll(spec);
    }

    @Override
    public VacuumCleaner create(VacuumCleaner vacuumCleaner)
    {
        return repository.save(vacuumCleaner);
    }

}
