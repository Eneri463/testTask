package com.example.testTask.specifications;

import com.example.testTask.dto.PostParamsDTO;
import com.example.testTask.models.Appliance;
import com.example.testTask.models.Model;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ParticularModelSpecification <T>{

    public Specification<T> mainFilters(PostParamsDTO postParamsDTO) {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            Fetch<Model, Appliance> model = root.fetch("model", JoinType.LEFT);
            Fetch<Model, Appliance> appliance = model.fetch("appliance", JoinType.LEFT);

            model.fetch("colour");
            model.fetch("size");
            appliance.fetch("type");
            appliance.fetch("producerCountry");
            appliance.fetch("producerCompany");

            if (postParamsDTO.getCountry() != null ) list.add(cb.equal(cb.upper(root.get("model").get("appliance").get("producerCountry").get("name")), postParamsDTO.getCountry().toUpperCase()));
            if (postParamsDTO.getCompany() != null ) list.add(cb.equal(cb.upper(root.get("model").get("appliance").get("producerCompany").get("name")), postParamsDTO.getCompany().toUpperCase()));
            if (postParamsDTO.getOnline() != null ) list.add(cb.equal(root.get("model").get("appliance").get("onlineOrder"), postParamsDTO.getOnline()));
            if (postParamsDTO.getInstallment() != null ) list.add(cb.equal(root.get("model").get("appliance").get("installmentPlan"), postParamsDTO.getInstallment()));
            if (postParamsDTO.getMin_price() != null) list.add(cb.greaterThanOrEqualTo(root.get("model").get("price"), postParamsDTO.getMin_price()));
            if (postParamsDTO.getMax_price() != null) list.add(cb.lessThanOrEqualTo(root.get("model").get("price"), postParamsDTO.getMax_price()));
            if (postParamsDTO.getColour() != null ) list.add(cb.equal(cb.upper(root.get("model").get("colour")), postParamsDTO.getColour().toUpperCase()));

            if (postParamsDTO.getSort() != null) {

                String[] partOfOrder = postParamsDTO.getSort().split(",");

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

    public Specification<T> mainFiltersName(String countryName)
    {
        return (root, query, cb) ->
        {
            List<Predicate> list = new ArrayList<Predicate>();

            //list.add(cb.like());

            //cb.like()personCriteriaQuery.where(criteriaBuilder.like(
                //criteriaBuilder.upper(personRoot.get(Person_.description)),
                //"%"+filter.getDescription().toUpperCase()+"%"));

            return null;
        };
    }


}
