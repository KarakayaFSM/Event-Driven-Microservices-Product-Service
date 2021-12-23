package com.fsm.estore.productservice.command.rest;

import com.fsm.estore.productservice.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel product) {

        final var createProductCommand =
                CreateProductCommand.builder()
                        .productId(UUID.randomUUID().toString())
                        .title(product.getTitle())
                        .quantity(product.getQuantity())
                        .price(product.getPrice())
                        .build();

        var result = "";

        try {
            result = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }

        return result;
    }

}
