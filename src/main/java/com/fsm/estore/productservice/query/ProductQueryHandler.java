package com.fsm.estore.productservice.query;

import com.fsm.estore.productservice.core.ProductMapper;
import com.fsm.estore.productservice.core.data.ProductRepository;
import com.fsm.estore.productservice.query.rest.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductQueryHandler {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @QueryHandler
    public List<ProductRestModel> findProducts(FindAllProductsQuery query) {
        return mapper.toProductRestModel(
                productRepository.findAll()
        );
    }

}
