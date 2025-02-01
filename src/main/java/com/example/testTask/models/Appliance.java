package com.example.testTask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "appliances")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private AppliancesType name; // наименование товара

    @NotNull
    @ManyToOne
    @JoinColumn(name = "country_id")
    private ProducerCountry producerCountry; // компания-производитель

    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private ProducerCompany producerCompany; // фирма-производитель

    @NotNull
    private boolean onlineOrder; // возможность заказа онлайн

    @NotNull
    private boolean installmentPlan; // возможность оплаты в рассрочку

    @OneToMany(mappedBy = "appliance", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<AllModels> modelList = new HashSet<>();


}
