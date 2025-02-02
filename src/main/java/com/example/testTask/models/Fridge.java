package com.example.testTask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fridge")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "number_of_doors")
    private int numberOfDoors;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "compressor_type_id")
    private FridgeCompressorType compressorType;

    @NotNull
    @OneToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
