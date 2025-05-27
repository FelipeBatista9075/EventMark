package dev.batist.EventMark.infrastructure.exceptions;

public class EventoDuplicadoException extends RuntimeException{

    public EventoDuplicadoException() {
        super("Evento Duplicado");
    }

    public EventoDuplicadoException(String message) {
        super(message);
    }
}
