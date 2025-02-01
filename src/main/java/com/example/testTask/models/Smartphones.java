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
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "serial_number")
    private String serialNumber;

    @NotNull
    @Column(name = "colour")
    private String colour;

    @NotNull
    @Column(name = "size")
    private String size;

    @NotNull
    @Column(name = "price")
    private double price;

    @NotNull
    @Column(name = "memory_size")
    private int memorySize;

    @NotNull
    @Column(name = "number_of_cameras")
    private int numberOfCameras;

    @NotNull
    @Column(name = "available")
    private boolean available;

}
