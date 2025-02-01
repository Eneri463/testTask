package com.example.testTask.models;

import com.example.testTask.models.compositeKeys.AllModelsId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "all_models")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllModels {

    @EmbeddedId
    AllModelsId id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "colour")
    private String colour;

    @NotNull
    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appliances_id")
    @MapsId("appliancesId")
    @NotNull
    private Appliance appliance;


}
