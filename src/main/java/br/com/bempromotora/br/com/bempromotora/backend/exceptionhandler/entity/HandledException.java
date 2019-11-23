package br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "HandledException")
@Data
public class HandledException {

    private String cause;

    private String message;

    private String stackTrace;

    private LocalDateTime dateTime;

}
