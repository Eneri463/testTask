package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ApplianceDTO {
    Long applianceId;
    @NotNull
    private String type;
    @NotNull
    private String company;
    @NotNull
    private String country;
    @NotNull
    private Boolean onlineOrder;
    @NotNull
    private Boolean installment;
}
