package com.fsm.estore.productservice.command;

import com.fsm.estore.productservice.core.ProductLookupMapper;
import com.fsm.estore.productservice.core.data.ProductLookupRepository;
import com.fsm.estore.productservice.core.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ProcessingGroup("product-group")
public class ProductLookupEventHandler {

    private final ProductLookupRepository lookupRepository;
    private final ProductLookupMapper mapper;

    @EventHandler
    void on(ProductCreatedEvent event) {
        lookupRepository.save(
                mapper.toProductLookup(event)
        );
    }

}
