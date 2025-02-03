package com.example.testTask.specifications;

import com.example.testTask.models.Appliance;
import com.example.testTask.models.Model;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ParticularModelSpecification <T>{

    public Specification<T> mainFilters(String countryName, String companyName, Boolean online,
                                        Boolean installment, Double priceMin, Double priceMax,
                                        String colourName, String orderBy) {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            Fetch<Model, Appliance> model = root.fetch("model", JoinType.LEFT);
            Fetch<Model, Appliance> appliance = model.fetch("appliance", JoinType.LEFT);

            model.fetch("colour");
            model.fetch("size");
            appliance.fetch("type");
            appliance.fetch("producerCountry");
            appliance.fetch("producerCompany");

            if (countryName != null ) list.add(cb.equal(cb.upper(root.get("model").get("appliance").get("producerCountry").get("name")), countryName.toUpperCase()));
            if (companyName != null ) list.add(cb.equal(cb.upper(root.get("model").get("appliance").get("producerCompany").get("name")), companyName.toUpperCase()));
            if (online != null ) list.add(cb.equal(root.get("model").get("appliance").get("onlineOrder"), online));
            if (installment != null ) list.add(cb.equal(root.get("model").get("appliance").get("installmentPlan"), installment));
            if (priceMin != null) list.add(cb.greaterThanOrEqualTo(root.get("model").get("price"), priceMin));
            if (priceMax != null) list.add(cb.lessThanOrEqualTo(root.get("model").get("price"), priceMax));
            if (colourName != null ) list.add(cb.equal(cb.upper(root.get("model").get("colour")), colourName.toUpperCase()));

            if (orderBy != null) {

                String[] partOfOrder = orderBy.split(",");

                if (partOfOrder[0].toUpperCase() == "PRICE")
                    if (partOfOrder.length > 1 && partOfOrder[1].toUpperCase() == "DESC")
                        query.orderBy(cb.desc(root.get("model").get("price")));
                    else query.orderBy(cb.asc(root.get("model").get("price")));
                else if (partOfOrder.length > 1 && partOfOrder[1].toUpperCase() == "DESC")
                    query.orderBy(cb.desc(root.get("model").get("name")));
                else query.orderBy(cb.asc(root.get("model").get("name")));
            } else query.orderBy(cb.asc(root.get("model").get("name")));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }

}
