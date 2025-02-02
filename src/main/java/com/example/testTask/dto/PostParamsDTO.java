package com.example.testTask.dto;

import lombok.Data;

@Data
public class PostParamsDTO {
    private String type; // вид техники

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
