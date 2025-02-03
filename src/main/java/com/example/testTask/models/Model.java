package com.example.testTask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name; // наименование модели

    @NotNull
    @Column(name = "serial_number")
    private String serialNumber; // серийный номер

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colour_id")
    private Colour colour; // цвет модели

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Size size; // размер модели

    @NotNull
    @Column(name = "price")
    private double price; // цена

    @NotNull
    @Column(name = "available")
    private boolean available; // в наличии

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appliances_id")
    private Appliance appliance; // к какой технике относится


}
