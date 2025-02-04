package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VacuumCleanerRequestDTO extends ModelRequestDTO{
    @NotNull
    private Integer volume;
    @NotNull
    private Integer numberOfModes;
}
