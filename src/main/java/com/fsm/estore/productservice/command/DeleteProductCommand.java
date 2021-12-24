package com.fsm.estore.productservice.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Getter
@Setter
@AllArgsConstructor
public class DeleteProductCommand {
    @TargetAggregateIdentifier
    private String productId;
}
