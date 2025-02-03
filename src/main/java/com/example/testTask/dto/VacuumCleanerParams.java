package com.example.testTask.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class VacuumCleanerParams extends PostParamsDTO{
    private Integer volume;
    private Integer number_of_modes;
}
