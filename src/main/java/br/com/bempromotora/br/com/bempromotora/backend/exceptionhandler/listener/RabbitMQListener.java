package br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.listener;

import br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.dto.ParsedHandledException;
import br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.service.HandledExceptionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQListener implements ListenerService{

    private final static String EXCEPTION_HANDLER_QUEUE = "handled-exception";

    @Autowired
    private HandledExceptionService handledExceptionService;

    @Autowired
    private Queue defaultQueue;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = {EXCEPTION_HANDLER_QUEUE})
    @Override
    public void onReceive(@Payload String payload) {
        try {
            log.info("Receive new handled exception...");
            ParsedHandledException parsedHandledException = objectMapper.readValue(payload, ParsedHandledException.class);
            log.info("Calling service layer for confirm handled exception");
            handledExceptionService.confirm(parsedHandledException);
        }catch(Exception e){
            log.error("Error on receive payload", e);
        }
    }

    @Bean
    public Queue getExceptionHandlerQueue(){
        return new Queue(EXCEPTION_HANDLER_QUEUE);
    }


}
