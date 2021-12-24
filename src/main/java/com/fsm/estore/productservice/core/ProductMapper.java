package com.fsm.estore.productservice.core;

import com.fsm.estore.productservice.core.data.Product;
import com.fsm.estore.productservice.query.rest.ProductRestModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductRestModel toProductRestModel(Product product);

    List<ProductRestModel> toProductRestModel(List<Product> products);
}
