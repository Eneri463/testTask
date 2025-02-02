package com.example.testTask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "computer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ComputerCategory category;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "processor_type_id")
    private ComputerProcessorType processorType;

    @NotNull
    @OneToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
