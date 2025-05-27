package dev.batist.EventMark.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EventoDuplicadoException.class)
    public ResponseEntity<Map<String, String>> handlerEventoDuplicadoExceptions(EventoDuplicadoException exception){
        Map<String,String> msg = new HashMap<>();
        msg.put("Error:", exception.getMessage());
        msg.put("Message:", "Please insert a valid hashId for the new event.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(msg);
    }

    @ExceptionHandler(EventoNaoEncontrado.class)
    public ResponseEntity<Map<String, String>> handlerEventoNotFound(EventoNaoEncontrado exc){
        Map<String, String> msg = new HashMap<>();
        msg.put("Error:", "Id not found in data base");
        msg.put("Messsage:", exc.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }


}
