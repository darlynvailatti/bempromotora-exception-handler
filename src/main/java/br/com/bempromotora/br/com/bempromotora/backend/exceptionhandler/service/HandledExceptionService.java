package br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.service;

import br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.dto.ParsedHandledException;
import br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.entity.HandledException;
import br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.repository.HandleExceptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandledExceptionService {

    @Autowired
    private HandleExceptionRepository handleExceptionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void confirm(ParsedHandledException parsedHandledException){
        HandledException handledExceptionEntity = modelMapper.map(parsedHandledException, HandledException.class);
        handleExceptionRepository.save(handledExceptionEntity);
    }

}
