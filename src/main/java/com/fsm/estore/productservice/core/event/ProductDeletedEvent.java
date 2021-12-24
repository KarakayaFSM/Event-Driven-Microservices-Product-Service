package com.fsm.estore.productservice.core.event;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class ProductDeletedEvent {
    @TargetAggregateIdentifier
    private String productId;
}
