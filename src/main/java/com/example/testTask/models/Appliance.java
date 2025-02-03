package com.example.testTask.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appliance_id")
    private ApplianceType type; // вид товара

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private ProducerCountry producerCountry; // компания-производитель

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private ProducerCompany producerCompany; // фирма-производитель

    @NotNull
    @Column(name = "online_order")
    private boolean onlineOrder; // возможность заказа онлайн

    @NotNull
    @Column(name = "installment_plan")
    private boolean installmentPlan; // возможность оплаты в рассрочку


}
