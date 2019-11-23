package br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.repository;

import br.com.bempromotora.br.com.bempromotora.backend.exceptionhandler.entity.HandledException;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HandleExceptionRepository extends MongoRepository<HandledException, String> {

}
