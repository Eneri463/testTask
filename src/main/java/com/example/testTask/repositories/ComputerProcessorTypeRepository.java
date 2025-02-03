package com.example.testTask.repositories;

import com.example.testTask.models.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerProcessorTypeRepository extends JpaRepository<Computer, Long> {
}
