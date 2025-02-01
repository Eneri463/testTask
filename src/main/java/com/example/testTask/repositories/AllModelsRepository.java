package com.example.testTask.repositories;

import com.example.testTask.models.AllModels;
import com.example.testTask.models.compositeKeys.AllModelsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AllModelsRepository extends JpaRepository<AllModels, AllModelsId>, JpaSpecificationExecutor<AllModels> {


}
