package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SmartphoneRequestDTO extends ModelRequestDTO{
    @NotNull
    private Integer numberOfCameras;
    @NotNull
    private Integer memorySize;
}
