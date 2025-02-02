package com.example.testTask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "television")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Television {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private TelevisionCategory category;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "technology_id")
    private TelevisionTechnology technology;

    @NotNull
    @OneToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
