package com.example.testTask.specifications;

import com.example.testTask.models.Smartphone;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SmartphoneSpecification extends ParticularModelSpecification<Smartphone>{
    public Specification<Smartphone> build(String country, String company, Boolean online,
                                       Boolean installment, Double priceMin, Double priceMax,
                                       String colour, String orderBy, Integer numberOfCameras, Integer memorySize)
    {
        return this.mainFilters(country, company, online, installment, priceMin, priceMax, colour, orderBy).and(addFilters(numberOfCameras, memorySize));
    }

    public Specification<Smartphone> addFilters(Integer numberOfCameras, Integer memorySize)
    {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            if (memorySize != null ) list.add(cb.equal(cb.upper(root.get("memorySize")), memorySize));
            if (numberOfCameras != null ) list.add(cb.equal(cb.upper(root.get("numberOfCameras")), numberOfCameras));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }
}
