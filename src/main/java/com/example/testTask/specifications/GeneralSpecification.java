package com.example.testTask.specifications;

import com.example.testTask.dto.PostParamsDTO;
import com.example.testTask.models.*;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// случай, когда нам не нужны особые атрибуты моделей, мы рассматриваем только общие
@Component
public class GeneralSpecification {

    public static Specification<Model> mainFilters(PostParamsDTO postParamsDTO) {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            Fetch<Model, Appliance> appliance = root.fetch("appliance");

            root.fetch("colour");
            root.fetch("size");
            appliance.fetch("type");
            appliance.fetch("producerCountry");
            appliance.fetch("producerCompany");

            // фильтрация
            if (postParamsDTO.getCountry() != null ) list.add(cb.equal(root.get("appliance").get("producerCountry").get("name"), postParamsDTO.getCountry()));
            if (postParamsDTO.getCompany() != null ) list.add(cb.equal(root.get("appliance").get("producerCompany").get("name"), postParamsDTO.getCompany()));
            if (postParamsDTO.getOnline() != null ) list.add(cb.equal(root.get("appliance").get("onlineOrder"), postParamsDTO.getOnline()));
            if (postParamsDTO.getInstallment() != null ) list.add(cb.equal(root.get("appliance").get("installmentPlan"), postParamsDTO.getInstallment()));
            if (postParamsDTO.getMin_price() != null) list.add(cb.greaterThanOrEqualTo(root.get("price"), postParamsDTO.getMin_price()));
            if (postParamsDTO.getMax_price() != null) list.add(cb.lessThanOrEqualTo(root.get("price"), postParamsDTO.getMax_price()));
            if (postParamsDTO.getColour() != null ) list.add(cb.equal(root.get("colour"), postParamsDTO.getColour()));
            if (postParamsDTO.getSize() != null ) list.add(cb.equal(root.get("size"), postParamsDTO.getSize()));
            if (postParamsDTO.getSerial_number() != null ) list.add(cb.equal(root.get("serialNumber"), postParamsDTO.getSerial_number()));

            // сортировка
            if (postParamsDTO.getSort() != null) {

                String[] partOfOrder = postParamsDTO.getSort().split(",");

                if (partOfOrder[0].toUpperCase() == "PRICE")
                    if (partOfOrder.length > 1 && partOfOrder[1].toUpperCase() == "DESC")
                        query.orderBy(cb.desc(root.get("price")));
                    else query.orderBy(cb.asc(root.get("price")));
                else if (partOfOrder.length > 1 && partOfOrder[1].toUpperCase() == "DESC")
                    query.orderBy(cb.desc(root.get("name")));
                else query.orderBy(cb.asc(root.get("name")));

            } else query.orderBy(cb.asc(root.get("name")));

            List<Predicate> list2 = new ArrayList<Predicate>();

            // поиск
            if (postParamsDTO.getSearch() != null)
            {
                Predicate[] p2 = new Predicate[list2.size()];

                String requiredStr = "%"+ postParamsDTO.getSearch().toUpperCase() + "%";

                list2.add(cb.like(cb.upper(root.get("name")), requiredStr));
                list2.add(cb.like(cb.upper(root.get("appliance").get("producerCountry").get("name")), requiredStr));
                list2.add(cb.like(cb.upper(root.get("appliance").get("producerCompany").get("name")), requiredStr));

                Predicate[] p = new Predicate[list2.size()];
                list.add(cb.or(list2.toArray(p)));
            }

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }

}
