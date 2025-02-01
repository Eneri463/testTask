package com.example.testTask.specifications;

import com.example.testTask.dto.PostParamsDTO;
import com.example.testTask.models.*;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneralSpecification {

    public static Specification<AllModels> filter(PostParamsDTO paramsDTO) {
        return (root, query, cb) -> {
            List<Predicate> list = new ArrayList<Predicate>();

            Join<AllModels, Appliance> appliance = root.join("appliance", JoinType.LEFT);
            Join<Appliance, AppliancesType> type = appliance.join("name");
            Join<Appliance, ProducerCountry> country = appliance.join("producerCountry");
            Join<Appliance, ProducerCompany> company = appliance.join("producerCompany");

            //if (paramsDTO.getType() != null ) list.add(cb.equal(type.get("name"), paramsDTO.getType()));
            //if (paramsDTO.getCountry() != null ) list.add(cb.equal(country.get("name"), paramsDTO.getCountry()));
            //if (paramsDTO.getCompany() != null ) list.add(cb.equal(company.get("name"), paramsDTO.getCompany()));
            if (paramsDTO.getOnline() != null ) list.add(cb.equal(appliance.get("onlineOrder"), paramsDTO.getOnline()));
            if (paramsDTO.getInstallment() != null ) list.add(cb.equal(appliance.get("installmentPlan"), paramsDTO.getInstallment()));
            //if (paramsDTO.getName()!= null ) list.add(cb.equal(root.get("name"), userGroupId));
            //if (paramsDTO.getPrice() != null ) list.add(cb.equal(root.get("price"), userGroupId));
            //if (paramsDTO.getColour() != null ) list.add(cb.equal(root.get("colour"), userGroupId));
            if (paramsDTO.getOrderByPrice() != null && paramsDTO.getOrderByPrice() != false) query.orderBy(cb.asc(root.get("price")));
            else query.orderBy(cb.asc(root.get("name")));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }

}
