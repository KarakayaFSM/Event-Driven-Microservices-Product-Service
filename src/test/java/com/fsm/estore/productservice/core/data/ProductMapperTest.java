package com.fsm.estore.productservice.core.data;

import com.fsm.estore.productservice.core.Product;
import com.fsm.estore.productservice.core.ProductMapperImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ProductMapperTest {
    private static ProductMapperImpl sut;

    @BeforeAll
    static void setup() {
        sut = new ProductMapperImpl();
    }

    @Test
    void shouldMapEntityToRestModel() {
        //given
        final var dummyProduct = getDummyProduct();

        //when
        final var result =
                sut.toProductRestModel(dummyProduct);

        Assertions
                .assertThat(result)
                .isNotNull()
                .hasNoNullFieldsOrProperties();
    }

    private Product getDummyProduct() {
        final var dummyProduct = new Product();

        dummyProduct.setProductId("ID");
        dummyProduct.setTitle("TITLE");
        dummyProduct.setPrice(BigDecimal.ONE);
        dummyProduct.setQuantity(1);
        return dummyProduct;
    }

}
