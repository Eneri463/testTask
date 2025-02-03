package com.example.testTask.repositories;

import com.example.testTask.models.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceRepository extends JpaRepository<Appliance, Long> {
}
