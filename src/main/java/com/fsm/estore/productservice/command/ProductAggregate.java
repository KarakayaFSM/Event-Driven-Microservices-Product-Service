package com.fsm.estore.productservice.command;

import com.fsm.estore.productservice.core.event.ProductCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;

    private String title;

    private BigDecimal price;

    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        if (command.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("price cannot be negative or zero");
        }

        final var event = new ProductCreatedEvent();
        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);

    }

    @CommandHandler
    public void deleteProduct(DeleteProductCommand command) {

    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.productId = event.getProductId();
        this.title = event.getTitle();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
    }

}
