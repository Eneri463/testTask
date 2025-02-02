package com.example.testTask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "smartphones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Smartphones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "memory_size")
    private int memorySize;

    @NotNull
    @Column(name = "number_of_cameras")
    private int numberOfCameras;

    @NotNull
    @OneToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
