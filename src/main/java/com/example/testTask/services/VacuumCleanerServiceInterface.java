package com.example.testTask.services;

import com.example.testTask.models.VacuumCleaner;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface VacuumCleanerServiceInterface{

    public List<VacuumCleaner> getAllVacuumCleaners(Specification<VacuumCleaner> spec);
}
