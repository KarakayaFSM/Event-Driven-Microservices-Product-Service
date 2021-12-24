package com.fsm.estore.productservice.command.rest;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class CreateProductRestModel {

    @NotBlank(message = "Title cannot be empty")
    private String title;
    @Min(value = 1, message = "price cannot be lower than 1")
    private BigDecimal price;
    @Min(value = 1, message = "price cannot be lower than 1")
    @Max(value = 5, message = "price cannot be higher than 5")
    private Integer quantity;
}
