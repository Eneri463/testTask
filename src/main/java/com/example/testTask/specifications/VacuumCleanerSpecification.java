package com.example.testTask.specifications;

import com.example.testTask.models.VacuumCleaner;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VacuumCleanerSpecification extends ParticularModelSpecification<VacuumCleaner>{

    public Specification<VacuumCleaner> build(String country, String company, Boolean online,
                                           Boolean installment, Double priceMin, Double priceMax,
                                           String colour, String orderBy, Integer volume, Integer numberOfModes)
    {
        return this.mainFilters(country, company, online, installment, priceMin, priceMax, colour, orderBy).and(addFilters(volume, numberOfModes));
    }

    public Specification<VacuumCleaner> addFilters(Integer volume, Integer numberOfModes)
    {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            if (volume != null ) list.add(cb.equal(cb.upper(root.get("memorySize")), volume));
            if (numberOfModes != null ) list.add(cb.equal(cb.upper(root.get("numberOfCameras")), numberOfModes));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }

}
