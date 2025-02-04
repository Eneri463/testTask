package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModelRequestDTO {

    @NotNull
    private Long applianceId;
    @NotNull
    private String name;
    @NotNull
    private String serialNumber;
    @NotNull
    private String colour;
    @NotNull
    private String size;
    @NotNull
    private double price;
    @NotNull
    private boolean available;
}
