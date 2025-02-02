package com.example.testTask.specifications;

import com.example.testTask.models.*;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneralSpecification {

    public static Specification<Model> filter(String countryName,String companyName,Boolean online,
                                              Boolean installment,Double priceMin,Double priceMax,
                                              String colourName, String orderBy) {
        return (root, query, cb) -> {
            List<Predicate> list = new ArrayList<Predicate>();


            Fetch<Model, Appliance> appliance = root.fetch("appliance", JoinType.LEFT);

            root.fetch("colour", JoinType.LEFT);
            root.fetch("size", JoinType.LEFT);
            appliance.fetch("name");
            appliance.fetch("producerCountry");
            appliance.fetch("producerCompany");

            //if (paramsDTO.getType() != null ) list.add(cb.equal(type.get("name"), paramsDTO.getType()));
            //if (paramsDTO.getCountry() != null ) list.add(cb.equal(country.get("name"), paramsDTO.getCountry()));
            //if (paramsDTO.getCompany() != null ) list.add(cb.equal(company.get("name"), paramsDTO.getCompany()));
            if (online != null ) list.add(cb.equal(root.get("appliance").get("onlineOrder"), online));
            if (installment != null ) list.add(cb.equal(root.get("appliance").get("installmentPlan"), installment));
            //if (paramsDTO.getName()!= null ) list.add(cb.equal(root.get("name"), userGroupId));
            //if (paramsDTO.getPrice() != null ) list.add(cb.equal(root.get("price"), userGroupId));
            //if (paramsDTO.getColour() != null ) list.add(cb.equal(root.get("colour"), userGroupId));
            if (orderBy != null) query.orderBy(cb.asc(root.get("price")));
            else query.orderBy(cb.asc(root.get("name")));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }

}
