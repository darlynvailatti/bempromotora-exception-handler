package br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParsedHandledException {

    private String cause;

    private String message;

    private String stackTrace;

    private LocalDateTime dateTime;

    public ParsedHandledException(){}

}
