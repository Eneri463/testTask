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

            // фильтрация
            if (postParamsDTO.getCountry() != null ) list.add(cb.equal(root.get("model").get("appliance").get("producerCountry").get("name"), postParamsDTO.getCountry()));
            if (postParamsDTO.getCompany() != null ) list.add(cb.equal(root.get("model").get("appliance").get("producerCompany").get("name"), postParamsDTO.getCompany()));
            if (postParamsDTO.getOnline() != null ) list.add(cb.equal(root.get("model").get("appliance").get("onlineOrder"), postParamsDTO.getOnline()));
            if (postParamsDTO.getInstallment() != null ) list.add(cb.equal(root.get("model").get("appliance").get("installmentPlan"), postParamsDTO.getInstallment()));
            if (postParamsDTO.getMin_price() != null) list.add(cb.greaterThanOrEqualTo(root.get("model").get("price"), postParamsDTO.getMin_price()));
            if (postParamsDTO.getMax_price() != null) list.add(cb.lessThanOrEqualTo(root.get("model").get("price"), postParamsDTO.getMax_price()));
            if (postParamsDTO.getColour() != null ) list.add(cb.equal(root.get("model").get("colour"), postParamsDTO.getColour()));
            if (postParamsDTO.getSize() != null ) list.add(cb.equal(root.get("model").get("size"), postParamsDTO.getSize()));
            if (postParamsDTO.getSerial_number() != null ) list.add(cb.equal(root.get("model").get("serialNumber"), postParamsDTO.getSerial_number()));

            // сортировка
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

            // поиск
            if (postParamsDTO.getSearch() != null)
            {
                List<Predicate> list2 = new ArrayList<Predicate>();
                Predicate[] p2 = new Predicate[list2.size()];

                String requiredStr = "%"+ postParamsDTO.getSearch().toUpperCase() + "%";

                list2.add(cb.like(cb.upper(root.get("model").get("name")), requiredStr));
                list2.add(cb.like(cb.upper(root.get("model").get("appliance").get("producerCountry").get("name")), requiredStr));
                list2.add(cb.like(cb.upper(root.get("model").get("appliance").get("producerCompany").get("name")), requiredStr));

                Predicate[] p = new Predicate[list2.size()];
                cb.or(list2.toArray(p));
            }

            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        };
    }

}
