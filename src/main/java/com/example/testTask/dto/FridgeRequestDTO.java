package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FridgeRequestDTO extends ModelRequestDTO{
    @NotNull
    private Integer numberOfDoors;
    @NotNull
    private String compressor;
}
