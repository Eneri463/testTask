package com.example.testTask.dto;

import lombok.Data;

@Data
public class VacuumCleanerParams extends ParamsDTO {
    private Integer volume;
    private Integer number_of_modes;
}
