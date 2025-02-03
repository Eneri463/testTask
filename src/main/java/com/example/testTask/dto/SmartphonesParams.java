package com.example.testTask.dto;

import lombok.Data;

@Data
public class SmartphonesParams extends PostParamsDTO{
    private Integer number_of_cameras;
    private Integer memory_size;
}
