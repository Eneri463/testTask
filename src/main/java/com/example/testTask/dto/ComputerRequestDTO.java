package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComputerRequestDTO extends ModelRequestDTO{
    @NotNull
    private String category;
    @NotNull
    private String processor;
}
