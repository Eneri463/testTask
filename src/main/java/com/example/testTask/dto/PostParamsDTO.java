package com.example.testTask.dto;

import com.example.testTask.models.AppliancesType;
import com.example.testTask.models.ProducerCompany;
import com.example.testTask.models.ProducerCountry;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostParamsDTO {
    private String type; // тип товара

    private String country; // компания-производитель

    private String company; // фирма-производитель

    private Boolean online; // возможность заказа онлайн

    private Boolean installment; // возможность оплаты в рассрочку

    private String name; // название товара

    private Double priceMin; // цена - нижняя граница
    private Double priceMax; // цена - верхняя граница

    private String colour; // цвет

    private Boolean orderByPrice; // тип сортировки

}
