package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VacuumCleanerDTO extends ModelDTO{

    private Integer volume;
    private Integer numberOfModes;
}
