package com.example.testTask.services;

import com.example.testTask.models.Television;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface TelevisionServiceInterface {

    public List<Television> getAllTelevisions(Specification<Television> spec);
    public Television create(Television television);
}
