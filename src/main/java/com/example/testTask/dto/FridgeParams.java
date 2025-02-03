package com.example.testTask.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class FridgeParams extends PostParamsDTO{

    private Integer number_of_doors;
    private String compressor;

}
