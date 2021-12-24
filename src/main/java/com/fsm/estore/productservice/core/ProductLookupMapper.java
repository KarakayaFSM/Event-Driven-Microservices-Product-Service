package com.fsm.estore.productservice.core;

import com.fsm.estore.productservice.core.data.ProductLookup;
import com.fsm.estore.productservice.core.event.ProductCreatedEvent;
import org.mapstruct.Mapper;

@Mapper
public interface ProductLookupMapper {
    ProductLookup toProductLookup(ProductCreatedEvent event);
}
