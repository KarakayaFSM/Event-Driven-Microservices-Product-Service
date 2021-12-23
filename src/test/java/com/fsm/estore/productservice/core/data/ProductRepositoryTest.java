package com.fsm.estore.productservice.core.data;

import com.fsm.estore.productservice.core.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldBeEmptyWhenProductNotFound() {
        final String dummyProductId = "asdf1234";

        final var product =
                productRepository
                        .findByProductId(dummyProductId);

        Assertions
                .assertThat(product)
                .isEmpty();
    }

    @Test
    void shouldBeEmptyWhenProductNotFoundByIdOrTitle() {
        final var dummyProductId = "asdf1234";
        final var dummyProductTitle = "dummyTitle";

        final var product =
                productRepository
                        .findByProductIdOrTitle(
                                dummyProductId, dummyProductTitle
                        );

        Assertions
                .assertThat(product)
                .isEmpty();
    }

}
