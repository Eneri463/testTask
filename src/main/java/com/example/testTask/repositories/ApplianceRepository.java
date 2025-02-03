package com.example.testTask.repositories;

import com.example.testTask.models.Appliance;
import com.example.testTask.models.ApplianceType;
import com.example.testTask.models.ProducerCompany;
import com.example.testTask.models.ProducerCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

    // todo
    @Query("""
            SELECT o
            FROM Appliance o
            WHERE o.type = :type AND o.producerCountry = :country
            AND o.producerCompany = :company
            """)
    List<Appliance> findByIds(@Param("type") ApplianceType type, @Param("company") ProducerCompany company, @Param("country") ProducerCountry country);
}
