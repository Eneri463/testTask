package com.example.testTask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vacuum_cleaner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacuumCleaner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "volume")
    private double volume;

    @NotNull
    @Column(name = "number_of_modes")
    private int numberOfModes;

    @NotNull
    @OneToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
