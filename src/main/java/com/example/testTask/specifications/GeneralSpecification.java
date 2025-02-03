package com.example.testTask.specifications;

import com.example.testTask.models.*;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// здесь случай, когда нам не нужны особые атрибуты моделей, мы рассматриваем только общие
@Component
public class GeneralSpecification {

    public static Specification<Model> mainFilters(String countryName,String companyName,Boolean online,
                                              Boolean installment,Double priceMin,Double priceMax,
                                              String colourName, String orderBy) {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            Fetch<Model, Appliance> appliance = root.fetch("appliance");

            root.fetch("colour");
            root.fetch("size");
            appliance.fetch("type");
            appliance.fetch("producerCountry");
            appliance.fetch("producerCompany");

            if (countryName != null ) list.add(cb.equal(cb.upper(root.get("appliance").get("producerCountry").get("name")), countryName.toUpperCase()));
            if (companyName != null ) list.add(cb.equal(cb.upper(root.get("appliance").get("producerCompany").get("name")), companyName.toUpperCase()));
            if (online != null ) list.add(cb.equal(root.get("appliance").get("onlineOrder"), online));
            if (installment != null ) list.add(cb.equal(root.get("appliance").get("installmentPlan"), installment));
            if (priceMin != null) list.add(cb.greaterThanOrEqualTo(root.get("price"), priceMin));
            if (priceMax != null) list.add(cb.lessThanOrEqualTo(root.get("price"), priceMax));
            if (colourName != null ) list.add(cb.equal(cb.upper(root.get("colour")), colourName.toUpperCase()));

            if (orderBy != null) {

                String[] partOfOrder = orderBy.split(",");

                if (partOfOrder[0].toUpperCase() == "PRICE")
                    if (partOfOrder.length > 1 && partOfOrder[1].toUpperCase() == "DESC")
                        query.orderBy(cb.desc(root.get("price")));
                    else query.orderBy(cb.asc(root.get("price")));
                else if (partOfOrder.length > 1 && partOfOrder[1].toUpperCase() == "DESC")
                    query.orderBy(cb.desc(root.get("name")));
                else query.orderBy(cb.asc(root.get("name")));
            } else query.orderBy(cb.asc(root.get("name")));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }

}
