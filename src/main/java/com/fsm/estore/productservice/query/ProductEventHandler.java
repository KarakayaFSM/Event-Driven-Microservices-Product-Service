package com.fsm.estore.productservice.query;

import com.fsm.estore.productservice.core.data.Product;
import com.fsm.estore.productservice.core.data.ProductRepository;
import com.fsm.estore.productservice.core.event.ProductCreatedEvent;
import com.fsm.estore.productservice.core.event.ProductDeletedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")
@RequiredArgsConstructor
public class ProductEventHandler {

    private final ProductRepository productRepository;

    @EventHandler
    void on(ProductCreatedEvent event) {
        final var product = new Product();
        BeanUtils.copyProperties(event, product);
        productRepository.save(product);
    }

    @EventHandler
    void on(ProductDeletedEvent event) {
        productRepository.deleteById(
                event.getProductId()
        );
    }

}
