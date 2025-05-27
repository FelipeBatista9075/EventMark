package dev.batist.EventMark.infrastructure.exceptions;

public class EventoNaoEncontrado extends RuntimeException {
    public EventoNaoEncontrado(String message) {
        super(message);
    }
}
