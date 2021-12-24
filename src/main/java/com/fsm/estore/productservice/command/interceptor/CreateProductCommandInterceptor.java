package com.fsm.estore.productservice.command.interceptor;

import com.fsm.estore.productservice.command.CreateProductCommand;
import com.fsm.estore.productservice.core.data.ProductLookup;
import com.fsm.estore.productservice.core.data.ProductLookupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateProductCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    private final ProductLookupRepository productLookupRepository;

    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
            List<? extends CommandMessage<?>> messages) {

        return (index, command) -> {
            log.info("Intercepted command: {}", command.getPayloadType());
            return doValidationOn(command);
        };
    }

    private CommandMessage<?> doValidationOn(CommandMessage<?> command) {
        if (isCreateProductCommand(command)) {
            validateCommand(
                    (CreateProductCommand) command.getPayload()
            );
        }

        return command;
    }

    private void validateCommand(CreateProductCommand createProductCommand) {
        final var productLookup =
                getProductLookupFrom(createProductCommand);

        if (productLookup.isPresent()) {
            throw new IllegalStateException(
                    String.format("Product with productId %s or title %s already exist",
                            createProductCommand.getProductId(), createProductCommand.getTitle())
            );
        }
    }

    private Optional<ProductLookup> getProductLookupFrom(CreateProductCommand createProductCommand) {
        return productLookupRepository.findByProductIdOrTitle(
                createProductCommand.getProductId(),
                createProductCommand.getTitle()
        );
    }

    private boolean isCreateProductCommand(CommandMessage<?> command) {
        return CreateProductCommand.class.equals(
                command.getPayloadType()
        );
    }

}
