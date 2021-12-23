package com.fsm.estore.productservice.core.event;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
public class ProductCreatedEvent {

    @TargetAggregateIdentifier
    private String productId;

    private String title;
    private BigDecimal price;
    private Integer quantity;
}
