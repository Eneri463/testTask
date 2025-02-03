package com.example.testTask.specifications;

import com.example.testTask.models.*;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComputerSpecification extends ParticularModelSpecification<Computer>{

    public Specification<Computer> build(String type, String country,String company,Boolean online,
                                                Boolean installment,Double priceMin,Double priceMax,
                                                String colour, String orderBy, String category, String processorType)
    {
        return this.mainFilters(type, country, company, online, installment, priceMin, priceMax, colour, orderBy).and(addFilters(category, processorType));
    }

    public Specification<Computer> addFilters(String category, String processorType)
    {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            root.fetch("category");
            root.fetch("appliance");

            if (category != null ) list.add(cb.equal(cb.upper(root.get("category").get("name")), category.toUpperCase()));
            if (processorType != null ) list.add(cb.equal(cb.upper(root.get("processorType").get("name")), processorType.toUpperCase()));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }

}
