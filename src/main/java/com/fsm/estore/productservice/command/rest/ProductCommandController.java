package com.fsm.estore.productservice.command.rest;

import com.fsm.estore.productservice.command.CreateProductCommand;
import com.fsm.estore.productservice.command.DeleteProductCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel product) {
        return commandGateway.sendAndWait(
                getCreateProductCommandFrom(product)
        );
    }

    private CreateProductCommand getCreateProductCommandFrom(CreateProductRestModel product) {
        return CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .title(product.getTitle())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .build();
    }

    @DeleteMapping("{productId}")
    public String deleteProduct(@PathVariable String productId) {
        return commandGateway.sendAndWait(
                new DeleteProductCommand(productId)
        );
    }

}
